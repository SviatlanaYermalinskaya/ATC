package HomeWork;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestMassive4 {
  Massive mass;		
  
  @DataProvider
  public Object[][] dp() 
  {
    return new Object[][] {
      new Object[] { 0, 1, 6 },
      new Object[] { 0, 2, 8 },
      new Object[] { 1, 2, 12 }
    };
  }
    
  @Test(dataProvider = "dp")
  public void testMultiplyMassiveNumbers(int a, int b, int c) 
  {
	  mass = new Massive(new int[] {2,3,4});
	  Assert.assertEquals(mass.multiplyMassiveNumbers(a, b), c);
  }
  
  @Test
  public void testsumAllNumbers()
  {
	  mass = new Massive(new int[] {1, 2, 3, 4}); 
	  Assert.assertEquals(mass.sumAllNumbers(), 10);
  }
  
  @Test
  public void testReverseMassive()
  {
	  mass = new Massive(new int[] {1, 2, 3, 4}); 
	  Assert.assertEquals(mass.reverseMassive()[0], 4);
  } 
  
  @Test
  public void testReverseMassive2()
  {
	  mass = new Massive(new int[] {1, 2, 3, 4}); 
	  Integer[] massInteger = Arrays.stream( mass.getMass() ).boxed().toArray( Integer[]::new );
	  Integer[] mass1Integer = Arrays.stream( mass.reverseMassive() ).boxed().toArray( Integer[]::new );
	  Assert.assertEqualsNoOrder(massInteger, mass1Integer);
  } 
  
  
  @Test
  public void testMin()
  {
	  mass = new Massive(new int[] {1, 2, -3, 4}); 
	  Assert.assertEquals(mass.min(), -3);
  } 
  
  @Test
  public void testSortMassive()
  {
	  mass = new Massive(new int[] {4, 5, 3, 2}); 
	  Integer[] massInteger = Arrays.stream( mass.getMass() ).boxed().toArray( Integer[]::new );
	  Integer[] mass1Integer = Arrays.stream( mass.sortMassive() ).boxed().toArray( Integer[]::new );
	  Assert.assertEqualsNoOrder(massInteger, mass1Integer);
  } 
  
  @Test
  public void testSortMassive2()
  {
	  mass = new Massive(new int[] {4, 5, 3, 2});
	  Assert.assertEquals(mass.sortMassive()[0], 2);
  } 
  
  @BeforeMethod
  public void beforeMethod() 
  {
	  TestMassive.method_num++;
	  mass = new Massive(new int[] {1,2,3});
	  System.out.println("Test 4 - BeforeMethod " + TestMassive.method_num);
  }

  @AfterMethod
  public void afterMethod() 
  {
	  System.out.println("Test 4 - AfterMethod " + TestMassive.method_num);
  }

}
