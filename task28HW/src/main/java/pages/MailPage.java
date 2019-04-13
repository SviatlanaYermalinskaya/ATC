package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage extends Page{
	
	
	private Actions action;
	private WebDriver driver;
	private WebDriverWait wait;
	
    public MailPage(WebDriver webdriver)
    {
    	super("mail");
        PageFactory.initElements(webdriver, this);
        this.driver = webdriver;
        wait = new WebDriverWait(driver, 10);
        action = new Actions(driver);
        MailPage.super.logger.debug(super.getType() + " page is created");
    }
/*    
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
*/
}
