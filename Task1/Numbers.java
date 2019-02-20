package core;

public class Numbers 
{
	public static void main(String[] args)
	{
		int i=5;
		short s=75;
		long l=345l;
		double d=0.546d;
		float f=-9.56f;
		char c='n';
		boolean bool=false;
		
		int result1;
		result1=i+s;
		
		double result2;
		result2=l-d;
		
		double result3;
		result3=f*d;
		
		System.out.print(result1+" "+result2+" "+result3+" ");
		System.out.println();
		
		if(l>d)
		{
			System.out.println("Больше");
		}
		else
		{
			System.out.println("Меньше");
		}
		
		if(f<i)
		{
			System.out.println("Меньше");
		}
		else
		{
			System.out.println("Больше");
		}
		
		if(i==l)
		{
			System.out.println("Равно");
		}
		else
		{
			System.out.println("Не равно");
		}
		
		if(s!=c)
		{
			System.out.println("Не равно");
		}
		else
		{
			System.out.println("Равно");
		}
		
		
	}

}
