package automationFramework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MailPage1;

public class TestMailPage1 {
	
	private WebDriver driver;
	private MailPage1 mPage;
	private int messages_number_to_select = 3;
	private int message_number_to_spam = 2;
	
	@Before
	public void before()
	{
		driver = new ChromeDriver();
		mPage = new MailPage1(driver);
	}
	

	@Test
	public void test1() 
	{	
		// логинимся
		driver.get("https://www.mail.ru/");
		mPage.enterLoginPassword("syermolinskaya", "ytdthjznyjtbpj,htntybt");
		mPage.clickButton();
		
	    // проверка, что залогинились
		Assert.assertTrue(mPage.isExitLinkPresent());	
		
		// проверка наличия писем
		Assert.assertTrue(mPage.hasIncomingMessage());
		
		// отправляем первое письмо в спам
		String msg_text = mPage.moveMessageToSpam(message_number_to_spam - 1);
		Assert.assertNotNull(msg_text);
		
		// переходим в папку спам, находим тот же письмо, что и переместили в спам, и возвращаем его во входящие
		mPage.openSpam();	
		Assert.assertTrue(mPage.hasMovedMessageFromSpam(msg_text));
		
		// напишем письмо и проверим, что оно отправлено
		mPage.sendMessage("orimailrb@gmail.com, esalana@tut.by, lanalex@tut.by", "Test6", "Hello!!!");
		Assert.assertTrue(mPage.isMessageSent());
		
		// возвращаемся в папку Входящие
		mPage.moveToIncome();	
	}
	
	@Test
	public void test2() 
	{	
		// логинимся
		driver.get("https://www.mail.ru/");
		mPage.enterLoginPassword("syermolinskaya", "ytdthjznyjtbpj,htntybt");
		mPage.clickButton();
		
	    // проверка, что залогинились
		Assert.assertTrue(mPage.isExitLinkPresent());	
		
		// вызов метода selectMessages и проверка, что указанное количество писем отмечены флажками
		Assert.assertTrue(mPage.selectMessages(messages_number_to_select));
		
		// Убираем флажки у всех писем
		mPage.unselectAllMessages();
		// проверка, что нет помеченных писем incoming_messages.get(i), "class", "selected" - пустой массив
		Assert.assertTrue(mPage.isUnselectedAllMessages());			
	}

	
	@After
	public void after()
	{
		driver.quit();
	}


}
