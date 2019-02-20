package HomeWork;

import java.util.Scanner;

public class Task4_2 
{
	public static void main(String[] args) 
	{			
		System.out.println("Введите размерность массива: ");
		int len = getIntegerMore1();
		
		int left = 0;
		int right = 100;
		double[] mass = new double[len];
		mass = setRandomMassive(mass, left, right);
		
		Massive m1 = new Massive();
		m1.printMassiveAsLine(mass);
		m1.printReverseMassiveAsLine(mass);
		System.out.println("Сумма элементов массива равна "+m1.getSumOfElements(mass));
		mass = m1.multiptyBy3(mass);
		m1.printMassiveAsLine(mass);
		m1.printReverseMassiveAsLine(mass);
					
	}
	
	public static double[] setRandomMassive (double[] mass, double left, double right)
	{
		for (int i = 0; i < mass.length; i++)
		{
			mass[i] = left + Math.random() * (right - left);		
		}
		return mass;
	}
	
	public static int getIntegerMore1()
	{
		Scanner my_scanner = new Scanner(System.in);
		if (my_scanner.hasNextInt())
		{
			int len = my_scanner.nextInt();
			if (len>1)
			{
				return len;
			}
			else
			{
				System.out.println("Размерность массива должна быть больше 1. Повторите ввод:");
				return getIntegerMore1();
			}
		}
		else
		{
			System.out.println("Ошибка ввода типа данных. Повторите ввод целого числа:");
			return getIntegerMore1();
		}
	}	
	
}
