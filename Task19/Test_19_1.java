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



public class Test_19_1 {
	private WebDriver driver;
	private WebDriverWait wait;
	private int addition_to_arrival_date = 3;
	private int period = 7;
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
		//driver.quit();
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
		
		//Нажимаем кнопку Найти для поиска подходящих отлей
		WebElement button_search = driver.findElement(By.xpath(".//button[@data-sb-id=\"main\"]"));
		button_search.click();
		
		List<WebElement> sliders = driver.findElements(By.xpath(".//a[@class=\"bui-slider__handle\"]"));
		// Находим все чекбоксы опции Выбрать по критериям (можно еще сделать проверку наличия опций Ваш бюджет)
		List<WebElement> cheapest_rooms_checkboxs = driver.findElements(By.xpath(".//div[@class=\"bui-checkbox__label filter_item css-checkbox\"]//span"));
		//Assert.assertTrue("There are no hotels from cheapest rang", sliders.isEmpty());
		// проверка как выведен блок Ваш бюджет в виде чекбокса или полосы прокрутки
					
		if (!sliders.isEmpty())
		{
			System.out.println("Slider is displayed");
			cheapest_rooms_checkboxs.get(2).click();	
			leftPrice = 110;
			rightPrice = 350;
			// если появилась прокрутка (лист sliders не пустой), то отелей из самого первого дешевого диапазона нет
		}
		else
		{		
			leftPrice = 0;
			rightPrice = 110;
			// выбор наименьшего диапазона цен
			cheapest_rooms_checkboxs.get(0).click();						
		}
			
	// Находим отфильтрованные отели и проверяем, что список не пустой
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String hotels_xpath = ".//div[@class=\"sr_item txp-pmc-prop sr_item_new sr_item_default sr_property_block  sr_flex_layout                 \"]";		
		List<WebElement> hotels = driver.findElements(By.xpath(hotels_xpath));	
		hotels.forEach(hotel->
		{
			wait.until(ExpectedConditions.visibilityOf(hotel));
		});		
		System.out.println("Число отфильтрованных отелей " + hotels.size());		
		Assert.assertFalse("There are no cheap hotels", hotels.isEmpty());
		
		// проверяем, что в списке есть отели с выставленным рейтингом
		List<WebElement> hotel_ratings_list = driver.findElements(By.xpath(".//div[@class=\"sr_item txp-pmc-prop sr_item_new sr_item_default sr_property_block  sr_flex_layout                 \"]//.//div[@class=\"bui-review-score__badge\"]"));
		System.out.println("Число отелей с рейтингом " + hotel_ratings_list.size());
		Assert.assertFalse("There are no hotels with rating", hotel_ratings_list.isEmpty());
		
		// Ищем максимальный рейтинг
		String max_rating = getMaxRating(hotels);
		System.out.println("Наибольший рейтинг " + max_rating);	
		
		// находим отель с наибольшим рейтингом
	    System.out.println(getHotelWithRating(hotels, max_rating).getAttribute("data-hotelid"));
	    
	    int hotel_highest_rating_number = getHotelIndexWithRating(hotels, max_rating);
	   
	    System.out.println("Индекс отеля " + hotel_highest_rating_number + " и его id " + hotels.get(hotel_highest_rating_number).getAttribute("data-hotelid"));
		
		//Находим стоимость отеля с наибольшим рейтингом
	    
	    List<WebElement> prices = driver.findElements(By.xpath(".//strong[contains(@aria-label,\"Цена за 7 ночей\")]"));
	    System.out.println(prices.get(hotel_highest_rating_number).getText());
	    price = getPrice(prices.get(hotel_highest_rating_number).getText());
	    System.out.println(price);
	    
	    // проверка на соответствие цены выбранному диапазону
	    Assert.assertTrue(isPriceInSelectedRange());

	}
	
	public boolean isPriceInSelectedRange()
	{
		return ((price >= leftPrice * period)&&(price <= rightPrice * period));
	}
	
	public int getPrice(String hotel_price)
	{
		return Integer.valueOf(hotel_price.replaceAll(" ", "").replaceAll("BYN", ""));	
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
	
	// Ищем отель с заданным рейтингом
	public WebElement getHotelWithRating(List<WebElement> hotels, String rating)
	{
		for (WebElement element: hotels)
		{
			if (rating.compareTo(element.getAttribute("data-score")) == 0)
			{
				return element;
			}
		}		
		return null;
	}
	
	// Ищем максимальный рейтинг у отлей
	public String getMaxRating(List<WebElement> hotels)
	{
		TreeSet<String> ratings = new TreeSet<String>();
		for (WebElement element: hotels)
		{
			ratings.add(element.getAttribute("data-score"));
		}
		return ratings.last();
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
