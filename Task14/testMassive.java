package core;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class testMassive {

	static int num = 0;
	
	@Before
	public void before()
	{
		num++;
		System.out.println(num + " test starts");
	}
	
	@After
	public void after()
	{
		System.out.println(num + " test ends");
	}	

	@BeforeClass
	public static void beforeClass()
	{
		System.out.println("Testing start:");
	}
	
	@AfterClass
	public static void afterClass()
	{
		System.out.println("Testing end.");
	}		
	
	@Ignore
	@Test
	public void test() 
	{
		fail("Not yet implemented");
	}
	
	@Ignore
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
	
	@Test(expected = ArithmeticException.class)
	public void testException() 
	{
		Massive massive1 = new Massive(new int[] {1, 2, 3, 4});
		System.out.println("Test exception");
		massive1.devideMassNumberByIndex(3,0);
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
	
	@Test
	public void testMassiveArrayEquals() 
	{
		Massive massive1 = new Massive(new int[] {1, 2, 3, 4});
		System.out.println("Arrays equal");
		Assert.assertArrayEquals( massive1.getMass(), new int[] {1, 2, 3, 4});	
	}	
	
	@Test
	public void testIsMassiveElementNull() 
	{
		Massive massive1 = new Massive(new int[] {1, 2, 0, 4});
		System.out.println("Third element is 0");
		Assert.assertThat( massive1.getMass()[2], is(0));	
	}	
}
