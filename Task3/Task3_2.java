package core;

public class Task3_2 {

	public static void main(String[] args) {
		

		int a = (int)(Math.random()*10);
		String str[] = {" четное"," нечетное"};
		int i=1;
		if (isEven(a))
		{
			i=0;
		}
	    System.out.println("Число "+a+str[i]);	
	
	}

	public static boolean isEven(int a)
	{
		if (a%2 == 0)
		{
			return true;
		}
		 
		return false;	
	}
}
