package homework;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BookingSteps {
	
    private BookingPage bookingPage;
    private WebDriver webDriver;
    private double min_priority = 9.0;
    
    public BookingSteps()
    {
        webDriver = new ChromeDriver();
        bookingPage = new BookingPage(webDriver);
    }
  
    @Given("^I am on main application page$")
    public void loadBookingPage()
    {
    	webDriver.get("https://www.booking.com/");
    }
    
    @When("^I search hotels by city name for current date$")
    public void searchHotelsByCity()
    {
		bookingPage.setCity("Москва");
		bookingPage.chooseArrivalDate();
		bookingPage.clickSearchButton();
    }
    
    @Then("^I check that search result is not empty$")
    public void isSearchNotEmpty()
    {	
    	Assert.assertFalse(bookingPage.isSearchResultEmpty());
    }
    
    @And("^I choose priority and open first hotel$")
    public void choosePriorityAndOpenFirstHotel()
    {
		bookingPage.choosePriority();
		bookingPage.openFirstHotel();
    }
    
    @Then("^I check that priority more than 9$")
    public void checkHotelPriority()
    {	
    	Assert.assertTrue(bookingPage.getHotelPriority() >= min_priority);
    }
    
    @After
    public void after()
    {
        webDriver.quit();
    }

}
