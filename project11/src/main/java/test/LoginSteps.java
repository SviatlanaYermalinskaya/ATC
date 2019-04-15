package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dom.DomParser;
import facade.LogPassExpXPathFromDBFacade;
import model.Message;
import pages.LoginPage;
import pages.MailPage;
import webdriver.WebDriverSingleton;

public class LoginSteps
{
	private static final Logger logger = Logger.getLogger(LoginSteps.class);
	private static final String MESSAGES_XML = "messages.xml";
    private static final String MAIN_URL = "http://mail.ru";
    
    private LoginPage loginPage;
    private MailPage mailPage;
    private WebDriver webDriver;

    private String expectedXPath; 
    private String message_text;
    private List<Message> messages;

    public LoginSteps()
    {
    	webDriver = WebDriverSingleton.getInstance();
        loginPage = new LoginPage(webDriver);
    }
    
    @Before(value = "@send_message", order = 10)
    public void getMessagesFromXML() 
    {
    	logger.info("Extract masseges from messages.xml");
        try
        {
            logger.debug("DOM parser: messages extracting...");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.parse(MESSAGES_XML);
            messages = new DomParser().parse(document);
            messages.forEach(message -> logger.debug(message));
        }
        catch (FileNotFoundException e)
        {
        	logger.error("Error: file messages.xml is not found.");
        }
        catch (XMLStreamException e)
        {
        	logger.error(e.getMessage());       	
        }
        catch (IOException | SAXException   e)
        {
        	logger.error(e.getMessage());       	
        }
        catch (ParserConfigurationException e)
        {
        	logger.error(e.getMessage());       	
        }
    }

    @Given("^I am on main application page$")
    public void loadMainPage()
    {
    	logger.info("test is started...");
        webDriver.get(MAIN_URL);
    }

    @When("^I login as user with \"([^\"]*)\"$")
    public void loginAsUserWithCredentials(String id)
    {    
    	logger.info("login test for user with id = " + id);
    	LogPassExpXPathFromDBFacade dbConnection = new LogPassExpXPathFromDBFacade(id);
    	
    	expectedXPath = dbConnection.getExpectedXPath();   	
    	Assert.assertNotNull("Error with BD connection:  expectedXPath is not initialized", expectedXPath);
    	
        loginPage.enterLoginAndPass(dbConnection.getLogin(), dbConnection.getPassword());
        loginPage.clickEnterButton();
    }

    @When("^I login as user with correct password$")
    public void loginAsUserWithCorrectPassword()
    {
    	String login = "syermolinskaya";
    	String password = "ytdthjznyjtbpj,htntybt";
    	expectedXPath = ".//a[@id=\"PH_logoutLink\"]";
        loginPage.enterLoginAndPass(login, password);
        loginPage.clickEnterButton();
        mailPage = new MailPage(webDriver);
    }
    
    @Then("^I see expected element$")
    public void seeLogoutLink()
    {
    	logger.info("Test login...");  
    	try
    	{
    		Assert.assertTrue("Login test is failed!", loginPage.isLogLinkPresents(expectedXPath));
        	logger.info("Login test is completed successfully");
    	}
    	catch (AssertionError e)
    	{
    		logger.error(e.getMessage());
    		throw e;
    	} 	
    }
    
    @Then("^I check incoming messages presence$")
    public void checkIncomingMessages()
    {
    	logger.debug("Check incoming messages presence...");   	
    	try
    	{
    		Assert.assertTrue("Test fails caused there are no incomming messages", mailPage.hasIncomingMessage());
    	}
    	catch (AssertionError e)
    	{
    		logger.error(e.getMessage());
    		throw e;
    	} 	 	
    }
    
    @When("^I move (\\d+) message to spam$")
    public void moveOneMessageToSpam(int number)
    {
    	logger.debug(number + " message is moving to spam...");
    	message_text = mailPage.moveMessageToSpam(number - 1);
    }
    
    @Then("^I see popup with confirmation$")
    public void checkPopupConfirmation()
    {
    	logger.debug("Wait message moving confirmation...");   	
    	try
    	{
    		Assert.assertTrue("Test fails caused there is no popup message with successful moving confirmation", mailPage.isPopupMessageMovingOkAppears());
    	}
    	catch (AssertionError e)
    	{
    		logger.error(e.getMessage());
    		throw e;
    	} 	 	
    }
    
    @When("^I go to spam$")
    public void goToSpam()
    {
    	mailPage.openSpam();;
    }
    
    @And("^I move message back from spam to income$")
    public void moveMessageBackFromSpam()
    {
    	logger.info("Moving message back to income");
    	try
    	{
    		Assert.assertTrue("Test fails because required message is not found", mailPage.hasMovedMessageFromSpam(message_text));
    	}
    	catch (AssertionError e)
    	{
    		logger.error(e.getMessage());
    		throw e;
    	} 	   	
    }
    
    @When("^I check (\\d+) messages$")
    public void checkMessages(int messages_number_to_select)
    {
    	try
    	{
    		Assert.assertTrue("Error: number of selected messages is less than required", mailPage.selectMessages(messages_number_to_select));
    	}
    	catch (AssertionError e)
    	{
    		logger.error(e.getMessage());
    		throw e;
    	} 	
    } 
    
    @And("^I uncheck all messages$")
    public void uncheckedAllMessage()
    {
    	logger.info("Uncheck all messages");
    	mailPage.unselectAllMessages(); 	
    }
     
    @Then("^I don't see any selection$")
    public void checkSelection()
    {
    	try
    	{
    		Assert.assertTrue("Error: not all messages are unselected", mailPage.isAllMessagesUnselected());
    	}
    	catch (AssertionError e)
    	{
    		logger.error(e.getMessage());
    		throw e;
    	} 	
    } 
    
    @When("^I send message using (\\d+) data$")
    public void sendMessage(int index)
    { 
    	logger.info("Send " + messages.get(index).toString());
    	mailPage.sendMessage(messages.get(index).getTo(), messages.get(index).getSubject(), messages.get(index).getMsgbody());
    } 
    
    @Then("^I see expected confirmation$")
    public void hasMessageSent()
    {
    	try
    	{
    		Assert.assertTrue("Error: message is not sent", mailPage.isMessageSent());
    	}
    	catch (AssertionError e)
    	{
    		logger.error(e.getMessage());
    		throw e;
    	} 	
    } 
    
    @After
    public void afterClass()
    {
    	logger.info("Test is completed!");
    	WebDriverSingleton.quit();
    }
}
