package HomeWork;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestMassive {
	
  public static int method_num=0;	

    @Test
	public void testNullAverage() 
	{
		Massive massive1 = new Massive(null);
		double exp_result = 0;
		double act_result = massive1.getAverage();

		System.out.println(act_result);
		Assert.assertEquals(exp_result, act_result, 0.0001);	
	}	
	
	@Test
	public void testAverageValue() 
	{
		Massive massive1 = new Massive(new int[] {1, 2, 3, 4});
		double exp_result = 2.5;
		double act_result = massive1.getAverage();

		System.out.println("Test value " + act_result);
		Assert.assertEquals(exp_result, act_result, 0.0001);	
	}
	
	@Test
	public void testNullMassive() 
	{
		Massive massive1 = new Massive(null);
		System.out.println("Massive pointer " + massive1.getMass());
		Assert.assertNull(massive1.getMass());	
	}
	
	@Test
	public void testNotNullMassive() 
	{
		Massive massive1 = new Massive(new int[] {1, 2, 3, 4});
		System.out.println("Massive pointer "+ massive1.getMass());
		Assert.assertNotNull( massive1.getMass());	
	}	

	@Test
	public void testIsMassiveLength10() 
	{
		Massive massive1 = new Massive(new int[10]);
		System.out.println("Check massive length 10");
		Assert.assertTrue(massive1.isMassiveLength10());
	}
	
	@Test
	public void testIsNotMassiveLength10() 
	{
		Massive massive1 = new Massive(null);
		System.out.println("Check massive length not 10");
		Assert.assertFalse(massive1.isMassiveLength10());
	}
	
	@Test
	public void testSameMassive() 
	{
		Massive massive1 = new Massive(new int[] {1, 2, 3, 4});
		Massive massive2 = massive1;
		System.out.println("The same massive");
		Assert.assertSame( massive1, massive2);	
	}	
	
	@Test
	public void testNotSameMassive() 
	{
		Massive massive1 = new Massive(new int[] {1, 2, 3, 4});
		Massive massive2 = new Massive(new int[] {1, 2, 3, 4});
		System.out.println("Not the same massive");
		Assert.assertNotSame( massive1, massive2);	
	}	
	
  
  
  

  
  @BeforeMethod
  public void beforeMethod() 
  {
	  method_num++;
	  System.out.println("Test 1 - BeforeMethod " + method_num);
  }

  @AfterMethod
  public void afterMethod() 
  {
	  System.out.println("Test 1 - AfterMethod " +method_num);
  }
  
  @BeforeClass
  public void beforeClass() 
  {
	  System.out.println("Test 1 - BeforeClass");
  }

  @AfterClass
  public void afterClass() 
  {
	  System.out.println("Test 1 - AfterClass");
  }

  @BeforeTest
  public void beforeTest() 
  {
	  System.out.println("Test 1 - BeforeTest");
  }

  @AfterTest
  public void afterTest() 
  {
	  System.out.println("Test 1 - AfterTest");
  }

  @BeforeSuite
  public void beforeSuite() 
  {
	  System.out.println("Test 1 - BeforeSuite");
  }

  @AfterSuite
  public void afterSuite() 
  {
	  System.out.println("Test 1 - AfterSuite");
  }

}
