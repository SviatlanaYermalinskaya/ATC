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

public class TestMassive3 {
	
  

  @Test(expectedExceptions = ArithmeticException.class)
  public void testException() 
  {
	  Massive massive1 = new Massive(new int[] {1, 2, 3, 4});
	  System.out.println("Test exception");
	  massive1.devideMassNumberByIndex(3,0);
  }
  
  @Test
  public void testIsNotMassiveLength10() 
  {
		Massive massive1 = new Massive(new int[] {1, 0, 0, 3, 7, 10, 1, 1, 1, 0, 14, 3});
		System.out.println("Check massive length not 10");
		Assert.assertFalse(massive1.isMassiveLength10());
  }
  
  @Test
  public void testSettMassiveNumberFalse() 
  {
		Massive massive1 = new Massive(new int[] {1, 0, 0, 3});
		System.out.println("Check massive length not 10");
		Assert.assertFalse(massive1.setMassNumber(5, 6));
  }
  
  
  @Test
  public void testDevideMassNumberByIndex() 
  {
	  Massive massive1 = new Massive(new int[] {1, 2, 3, 4});
	  Assert.assertEquals(massive1.devideMassNumberByIndex(3,2), 2);
	  
  }  
  
  
  @BeforeMethod
  public void beforeMethod() 
  {
	  TestMassive.method_num++;
	  System.out.println("Test 3 - BeforeMethod " + TestMassive.method_num);
  }

  @AfterMethod
  public void afterMethod() 
  {
	  System.out.println("Test 3 - AfterMethod " + TestMassive.method_num);
  }
  
  @BeforeClass
  public void beforeClass() 
  {
	  System.out.println("Test 3 - BeforeClass");
  }

  @AfterClass
  public void afterClass() 
  {
	  System.out.println("Test 3 - AfterClass");
  }

  @BeforeTest
  public void beforeTest() 
  {
	  System.out.println("Test 3 - BeforeTest");
  }

  @AfterTest
  public void afterTest() 
  {
	  System.out.println("Test 3 - AfterTest");
  }

  @BeforeSuite
  public void beforeSuite() 
  {
	  System.out.println("Test 3 - BeforeSuite");
  }

  @AfterSuite
  public void afterSuite() 
  {
	  System.out.println("Test 3 - AfterSuite");
  }

}
