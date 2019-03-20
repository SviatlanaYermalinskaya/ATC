package automationFramework;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task_18_1 {

	@Test
	public void test1() 
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
		
		try 
		{
			Thread.sleep(3000);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}	
		
		List<WebElement> hotel_list = driver.findElements(By.xpath(".//div[@class=\"sr_item  sr_item_new sr_item_default sr_property_block  sr_flex_layout                 \"]"));
		Assert.assertFalse(hotel_list.isEmpty());
		driver.close();

	}

}
