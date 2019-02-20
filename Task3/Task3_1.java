package core;

public class Task3_1 {

	public static void main(String[] args) {
		
		double a;
		a = Math.random()*10;
		double b;
		b = Math.random()*10;
	    System.out.println("Mинимальное из чисел "+a+" "+b+" равно "+minValue(a,b));	
	
	}

	public static double minValue(double a, double b)
	{
		if (a<b)
		{
			return a;
		}
		 
		return b;	
	}
}
