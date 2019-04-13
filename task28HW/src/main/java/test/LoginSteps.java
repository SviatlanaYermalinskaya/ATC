package test;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fasad.LogPassExpXPathFromDBFasad;
import pages.LoginPage;
import pages.MailPage;
import webdriver.WebDriverSingleton;

public class LoginSteps
{
	private static final Logger logger = Logger.getLogger(LoginSteps.class);
    private static final String MAIN_URL = "http://mail.ru";
    
    private LoginPage loginPage;
    private MailPage mailPage;
    private WebDriver webDriver;

    private String expectedXPath; 

    public LoginSteps()
    {
    	webDriver = WebDriverSingleton.getInstance();
        loginPage = new LoginPage(webDriver);
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
    	logger.info("login test with id = " + id);
    	LogPassExpXPathFromDBFasad dbConnection = new LogPassExpXPathFromDBFasad(id);
    	
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
    
    @Then("I see expected element")
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
     
    @After
    public void afterClass()
    {
    	WebDriverSingleton.quit();
    }
}
