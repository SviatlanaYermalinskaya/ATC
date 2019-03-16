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

public class TestMassive2 {
	Massive mass;
	
	
  @Test(enabled=false, expectedExceptions = ArithmeticException.class)
  public void testException() 
  {
	  Massive massive1 = new Massive(new int[] {1, 2, 3, 4});
	  System.out.println("Test exception");
	  massive1.devideMassNumberByIndex(3,0);
  }
  
  @DataProvider
  public Object[][] dp() 
  {
    return new Object[][] {
      new Object[] { 10, 3, 30 },
      new Object[] { 2, 7, 14 },
      new Object[] { 0, 7, 0 }
    };
  }
    
  @Test(dataProvider = "dp")
  public void testMultiplyMassiveOnNumber(int a, int b, int c) 
  {
	  mass = new Massive(new int[] {a,3,20});
	  int[]  mass1 = mass.multiplyMassiveOnNumber(b);
	  Assert.assertEquals(mass1[0], c);
  }
  
  @Test 
  public void testMultiplyMassiveOnNumber1()
  {
	  int[]  mass1 = mass.multiplyMassiveOnNumber(6);
	  Assert.assertEquals(mass1[1], 12);
  }
  
  @Test(dataProvider = "dp")
  public void testMultiplyMassiveOnNumber2(int a, int b, int c) 
  {
	  mass.setMassNumber(2, a);
	  int[]  mass1 = mass.multiplyMassiveOnNumber(b);
	  Assert.assertEquals(mass1[2], c);
  }
  
  @BeforeMethod
  public void beforeMethod() 
  {
	  TestMassive.method_num++;
	  mass = new Massive(new int[] {1,2,3});
	  System.out.println("Test 2 - BeforeMethod " + TestMassive.method_num);
  }

  @AfterMethod
  public void afterMethod() 
  {
	  System.out.println("Test 2 - AfterMethod " + TestMassive.method_num);
  }
  
  @BeforeClass
  public void beforeClass() 
  {
	  System.out.println("Test 2 - BeforeClass");
  }

  @AfterClass
  public void afterClass() 
  {
	  System.out.println("Test 2 - AfterClass");
  }

  @BeforeTest
  public void beforeTest() 
  {
	  System.out.println("Test 2 - BeforeTest");
  }

  @AfterTest
  public void afterTest() 
  {
	  System.out.println("Test 2 - AfterTest");
  }

  @BeforeSuite
  public void beforeSuite() 
  {
	  System.out.println("Test 2 - BeforeSuite");
  }

  @AfterSuite
  public void afterSuite() 
  {
	  System.out.println("Test 2 - AfterSuite");
  }

}
