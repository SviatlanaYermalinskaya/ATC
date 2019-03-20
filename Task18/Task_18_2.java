package automationFramework;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task_18_2 {

	@Test
	public void test2() 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.booking.com/");
		WebElement searchField = driver.findElement(By.xpath(".//input[@id=\"ss\"]"));
		searchField.sendKeys("Москва");
		searchField.submit();
		
		WebElement data_begin = driver.findElement(By.xpath(".//td[@class=\"c2-day c2-day-s-today\"]"));
		data_begin.click();
		
		WebElement button_search = driver.findElement(By.xpath(".//button[@data-sb-id=\"main\"]"));
		button_search.click();
		
		WebElement button_dots = driver.findElement(By.xpath(".//button[@id=\"sortbar_dropdown_button\"]"));
		button_dots.click();
				
		WebElement priority = driver.findElement(By.xpath(".//li[@class=\" sort_category   sort_bayesian_review_score \"]"));
		priority.click();
		
		try 
		{
			Thread.sleep(3000);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}	
		
		WebElement firstHotel = driver.findElement(By.xpath("(.//a[@class=\"b-button b-button_primary sr_cta_button\"])[1]"));
		firstHotel.click();
		
		WebElement assessment = driver.findElement(By.xpath(".//div[@class=\"bui-review-score__badge\"]"));		
		String hotel_assessment = assessment.getText().replace(',', '.');
		
		Assert.assertTrue(Double.valueOf(hotel_assessment) >= 9.0);
		driver.quit();

	}

}
