package pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage1 
{

	@FindBy (id = "mailbox:login")
	WebElement loginField;
	
	@FindBy (id = "mailbox:password")
	WebElement passwordField;
	
	@FindBy (id = "mailbox:submit")
	WebElement button_search;
	
	@FindBy (xpath = ".//a[@id=\"PH_logoutLink\"]")
	WebElement exitLink;
	
	@FindBy (xpath = ".//div[@data-bem=\"b-datalist__item\"]")
	List<WebElement> incoming_messages;
		
	@FindBy (xpath = ".//span[@class=\"js-txt _js-title notify-message__title__text notify-message__title__text_ok\"]")
	WebElement popup_moved_to_spam;
	
	@FindBy (xpath = ".//div[@data-id=\"950\"]")
	WebElement spam;
	
	@FindBy (xpath = ".//a[@cnt_sb=\"964649\"]")
	WebElement to_incoming_messages;
	
	@FindBy (xpath = ".//div[@data-cache-key=\"950_undefined_false\"]//div[@class=\"b-datalist__body\"]//div[@data-bem=\"b-datalist__item\"]")
	List<WebElement> spam_messages;	
	
	@FindBy (xpath = "(.//span[@class=\"b-toolbar__btn__text b-toolbar__btn__text_pad\"])[1]")
	WebElement button_write_message;
	
	//@FindBy (id = "compose_to")
	@FindBy (xpath = "//textarea[@class=\"js-input compose__labels__input\"]")
	WebElement input_addressees;
	
	@FindBy (xpath = ".//input[@name=\"Subject\"]")
	WebElement input_subject;
	
	@FindBy (xpath = ".//span[@class=\"b-toolbar__btn__text\"]")
	WebElement button_send_message;
	
	@FindBy (xpath = "(.//button[@class=\"btn btn_stylish btn_main confirm-ok\"])[2]")
	WebElement button_approve_message;
	
	@FindBy (xpath = ".//div[@id=\"MailRuConfirm\"]")
	WebElement popup_mail_confirm;
	
	@FindBy (xpath = ".//div[@class=\"message-sent__title\"]")
	WebElement message_sent;
	
	@FindBy (xpath = ".//div[@class=\"b-checkbox__box\"]")
	List<WebElement> checkboxes;
	
	@FindBy(xpath = "//iframe[contains(@id, 'composeEditor_ifr')]")
	WebElement msg_text_frame;
	
	@FindBy (xpath = "//body[@id='tinymce']")
	WebElement msg_text;
	
	@FindBy (xpath = ".//div[@data-id=\"0\"]")
	WebElement income;
	
	@FindBy (xpath = ".//div[@id=\"adman-line\"]")
	WebElement adv;
	
	
	
	private Actions action;
	private WebDriver driver;
	private WebDriverWait wait;
	
	public MailPage1(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
	}
	
	public void enterLoginPassword(String login, String password)
	{
		loginField.clear();
		loginField.sendKeys(login);
		passwordField.clear();
		passwordField.sendKeys(password);
	}
	
	public void clickButton()
	{
		button_search.click();
        wait.until(ExpectedConditions.titleContains("Входящие"));
	}
	
	public boolean isExitLinkPresent()
	{
		return exitLink.isDisplayed();
	}
	
	public boolean hasIncomingMessage ()
	{
		if (incoming_messages.isEmpty())
		{
			return false;
		}
		return true;
	}
	
	public String moveMessageToSpam (int message_number)
	{
		if (message_number >= incoming_messages.size())
		{
			return null;
		}			
		String result = incoming_messages.get(message_number).getText();
		action.contextClick(incoming_messages.get(message_number)).sendKeys("j").build().perform();
		
		wait.until(ExpectedConditions.visibilityOf(popup_moved_to_spam));
		wait.until(ExpectedConditions.invisibilityOf(popup_moved_to_spam));
		
		return result;
	}
	
	public void openSpam()
	{				
		spam.click();
		wait.until(ExpectedConditions.titleContains("Спам"));	
	}
	
	public boolean hasMovedMessageFromSpam(String msg_text)
	{
		for (WebElement msg: spam_messages)
		{
			if (msg_text.equals(msg.getText()))
			{
				action.contextClick(msg).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).
				sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
			
				wait.until(ExpectedConditions.visibilityOf(popup_moved_to_spam));
				wait.until(ExpectedConditions.invisibilityOf(popup_moved_to_spam));
				
				return true;
			}
		}		
		return false;
	}
	
	public void sendMessage(String address, String subject, String text)
	{
		button_write_message.click();
		wait.until(ExpectedConditions.titleContains("Новое письмо"));
		
		input_addressees.clear();
		input_addressees.sendKeys(address);
		
		input_subject.clear();
		input_subject.sendKeys(subject);		

		driver.switchTo().frame(msg_text_frame);
		msg_text.clear();
		msg_text.sendKeys(text);
		
		driver.switchTo().defaultContent();
		button_send_message.click();
 			
	}
	
	public void moveToIncome()
	{				
		to_incoming_messages.click();
		wait.until(ExpectedConditions.titleContains("Входящие"));
	}
	
	public boolean isMessageSent()
	{
		wait.until(ExpectedConditions.visibilityOf(message_sent));
		return message_sent.isDisplayed();
	}
	
	public boolean isUnselectedAllMessages()
	{	
		for (WebElement msg: incoming_messages)
		{
			if (msg.getAttribute("class").contains("selected"))
			{
				return false;
			}
		}
		return true;
	}	
	
	public void unselectAllMessages()
	{
		action.keyDown(Keys.CONTROL).sendKeys("a")
        .keyUp(Keys.CONTROL).build().perform();
	}
	
	public boolean selectMessages(int number)
	{
		int selected_message_number = 0;
		for (int i = 0; i < checkboxes.size(); i++)
		{
			checkboxes.get(i+2).click();
			selected_message_number++;
			if (number == selected_message_number)
			{
				return true;
			}				
		}
		return false;
	}
	
}
