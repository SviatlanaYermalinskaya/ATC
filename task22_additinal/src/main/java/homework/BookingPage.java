package homework;

import java.util.List;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingPage 
{
	private WebDriverWait wait;
	
    @FindBy(id = "sr_notice_no_dorms")
    private WebElement notice;

    @FindBy(xpath = ".//input[@id=\"ss\"]")
    private WebElement search_field;
    
    @FindBy(xpath = ".//td[contains(@class,\"c2-day-s-today\")]")
    private WebElement data_begin;
    
    @FindBy(xpath = ".//button[@data-sb-id=\"main\"]")
    private WebElement button_search;
    
    @FindBy(xpath = ".//span[contains(@class,\"sr-hotel__name\")]")
    private List<WebElement> hotel_name_list;
    
    @FindBy(xpath = ".//button[@id=\"sortbar_dropdown_button\"]")
    private WebElement button_dots;
    
    @FindBy(xpath = ".//li[@class=\" sort_category   sort_bayesian_review_score \"]")
    private WebElement priority;
    
    @FindBy(id = "sr_notice_minimum_number_of_reviews")
    private WebElement notice_min;
    
    @FindBy(xpath = "(.//a[@class=\"b-button b-button_primary sr_cta_button\"])[1]")
    private WebElement first_hotel;
    
    @FindBy(xpath = ".//div[@class=\"bui-review-score__badge\"]")
    private WebElement assessment;
   
	
	public BookingPage(WebDriver driver)
	{
		wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);
	}
	
	public void setCity(String city)
	{
		search_field.clear();
		search_field.sendKeys(city);
		search_field.submit();
	}
	
	public void chooseArrivalDate()
	{
		data_begin.click();
	}
	
	public void clickSearchButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(button_search));
		button_search.click();	
	}
	
	public boolean isSearchResultEmpty()
	{
		try 
		{
		    wait.until(ExpectedConditions.visibilityOf(notice));
		}
		catch (TimeoutException e)
		{		
		}		
		return hotel_name_list.isEmpty();
	}
	
	public void choosePriority()
	{
		button_dots.click();
		priority.click();
		wait.until(ExpectedConditions.visibilityOf(notice_min));
	}
	
	public void openFirstHotel()
	{
		first_hotel.click();
	}
	
	public double getHotelPriority()
	{
		String hotel_assessment = assessment.getText().replace(',', '.');
		return Double.valueOf(hotel_assessment);
	}
}
