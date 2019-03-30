package homework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BookingPage;

public class TestBookingPage {

	private WebDriver driver;
	private BookingPage bookingPage;
	private double min_priority = 9.0;
	
	@Before
	public void before()
	{
		driver = new ChromeDriver();
		bookingPage = new BookingPage(driver);
	}
	
	@Test
	public void test1() 
	{
		driver.get("https://www.booking.com/");
		
		bookingPage.setCity("Москва");
		bookingPage.chooseArrivalDate();
		bookingPage.clickSearchButton();		
		
		Assert.assertFalse(bookingPage.isSearchResultEmpty());		
	}
	
	//@Ignore
	@Test
	public void test2() 
	{
		driver.get("https://www.booking.com/");
		
		bookingPage.setCity("Москва");
		bookingPage.chooseArrivalDate();
		bookingPage.clickSearchButton();
		
		bookingPage.choosePriority();
		bookingPage.openFirstHotel();

		Assert.assertTrue(bookingPage.getHotelPriority() >= min_priority);			
	}
	
	@After
	public void after()
	{
		driver.quit();
	}

}
