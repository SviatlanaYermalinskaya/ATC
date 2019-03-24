package automationFramework;

import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Test_19_2 {
	private WebDriver driver;
	private WebDriverWait wait;
	private int addition_to_arrival_date = 3;
	private int period = 7;
	private int rooms_number = 2;
	private int leftPrice = 0;
	private int rightPrice = 477;
	private int price;
	
	
	@Before
	public void before()
	{
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
	}
	
	@After
	public void after()
	{
		driver.quit();
	}

	@Test
	public void test() 
	{
		driver.get("https://www.booking.com/");
		
		//Выбираем город Париж
		WebElement searchField = driver.findElement(By.xpath(".//input[@id=\"ss\"]"));
		searchField.sendKeys("Париж");
		searchField.submit();
		
		//Выбор текущей даты
		List<WebElement> dates = driver.findElements(By.xpath(".//td[contains(@class,\"c2-day \")]"));
		
		// Устанавливаем дату заезда на сегодня + 3 дня
		int today_index = getDateIndexWithStr(dates, "today");
		dates.get(today_index + addition_to_arrival_date).click();
		
		//Разворачиваем календарь на дату отъезда
		driver.findElement(By.xpath("(.//i[@class=\"sb-date-field__chevron bicon-downchevron\"])[2]")).click();

		//Устанавливаем дату отъезда как +7 дней к дате заезда
		dates = driver.findElements(By.xpath(".//td[contains(@class,\"c2-day \")]"));	
		int first_date_index = getDateIndexWithStr(dates, "c2-day c2-day-s-in-range c2-day-s-first-in-range");
		dates.get(first_date_index + period).click();
		
		WebElement adults = driver.findElement(By.xpath(".//select[@name=\"group_adults\"]"));
		Select adult_dropdown = new Select(adults);
		adult_dropdown.selectByVisibleText("4 взрослых");
		
		WebElement rooms = driver.findElement(By.xpath(".//select[@name=\"no_rooms\"]"));
		Select rooms_dropdown = new Select(rooms);
		rooms_dropdown.selectByVisibleText("2 номера");
		
		//Нажимаем кнопку Найти для поиска подходящих отлей
		WebElement button_search = driver.findElement(By.xpath(".//button[@data-sb-id=\"main\"]"));
		button_search.click();

		List<WebElement> sliders = driver.findElements(By.xpath(".//a[@class=\"bui-slider__handle\"]"));
		// Находим все чекбоксы опции Выбрать по критериям (можно еще сделать проверку наличия опций Ваш бюджет)
		List<WebElement> cheapest_rooms_checkboxs = driver.findElements(By.xpath(".//div[@class=\"bui-checkbox__label filter_item css-checkbox\"]//span"));
		// проверка как выведен блок Ваш бюджет в виде чекбокса или полосы прокрутки
					
		if (!sliders.isEmpty())
		{
			System.out.println("Slider is displayed");
			cheapest_rooms_checkboxs.get(8).click();	
			leftPrice = 250;
			rightPrice = 477;
			// если появилась прокрутка (лист sliders не пустой), то отелей из самого первого дешевого диапазона нет
		}
		else
		{		
	        // выбор набольшего диапазона цен
			leftPrice = 950;
			rightPrice = 9000;
			cheapest_rooms_checkboxs.get(8).click();	
					
		}
		
	// Находим отфильтрованные отели и проверяем, что список не пустой
		String hotels_xpath = ".//div[@class=\"sr_item txp-pmc-prop sr_item_new sr_item_default sr_property_block  sr_flex_layout                 \"]";		
		List<WebElement> hotels = driver.findElements(By.xpath(hotels_xpath));	
		hotels.forEach(hotel->
		{
			wait.until(ExpectedConditions.visibilityOf(hotel));
		});			
		Assert.assertFalse("There are no cheap hotels", hotels.isEmpty());
		
		// берем отели с указанной ценой
	    List<WebElement> prices = driver.findElements(By.xpath(".//div[@class=\"sr_item txp-pmc-prop sr_item_new sr_item_default sr_property_block  sr_flex_layout                 \"]//.//strong[contains(@aria-label,\"Цена за 4 взрослых\")]"));
	    System.out.println("Число отфильтрованных отелей " + prices.size());
	    int min_price_hotel_index = getHotelIndexWithMinPrice(prices);

	    System.out.println("Индекс отеля с наилучшей ценой " + min_price_hotel_index);

	    // проверка на соответствие цены выбранному диапазону
	    Assert.assertTrue(isPriceInSelectedRange());

	}
	
	public int getHotelIndexWithMinPrice(List<WebElement> prices)
	{
		int[] hotel_price = new int[prices.size()];
		TreeSet<Integer> sorted_prices = new TreeSet<Integer>();
		for (int i = 0; i < prices.size(); i++)
		{
			String current_price = prices.get(i).getAttribute("aria-label").replaceAll("\\D", "");
			current_price = current_price.replaceFirst("47", "");
	        hotel_price[i] = Integer.valueOf(current_price);
	        sorted_prices.add(hotel_price[i]);
		}
		price = sorted_prices.first();
		System.out.println("Наименьшая цена " + price);		
		for (int i = 0; i < prices.size(); i++)
		{
			if (hotel_price[i] == price)
			{
				return i;
			}
		}			
		return -1;
	}
	
	public boolean isPriceInSelectedRange()
	{
		return ((price >= leftPrice * period * rooms_number)&&(price <= rightPrice * period * rooms_number));
	}
	

	
	public int getHotelIndexWithRating(List<WebElement> hotels, String rating)
	{
		for (int i = 0; i < hotels.size(); i++)
		{
			if (rating.compareTo(hotels.get(i).getAttribute("data-score")) == 0)
			{
				return i;
			}
		}		
		return -1;
	}
	
	// находим индекс вэбэлемента в листе, содержащего строку str в значении атрибута class
	public int getDateIndexWithStr (List<WebElement> elements, String str)
	{
		
		for (int i = 0; i < elements.size(); i++)
		{
			if (elements.get(i).getAttribute("class").contains(str))
			{
				return i;
			}
		}		
		return -1;
	}

}
