package core;

public class Task3_4 {

	public static void main(String[] args) {
		
		int a = (int)(Math.random()*10);
        System.out.println("Куб числа "+a+" равен "+cube(a));	
	
	}

	public static int cube (int a)
	{
		return a*a*a;	
	}
}
