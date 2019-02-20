package core;

import java.util.Scanner;

// каждый 3-й элемент умножить на 2 (2-мя способами) 
public class Task2_3
{
	public static void main(String[] args)
	{
		System.out.println("Введите размерность массива (целое число больше 1): ");
		Scanner myScanner=new Scanner(System.in);
		int mas_len;
		if (myScanner.hasNextInt())
		{
			mas_len=myScanner.nextInt();
			if (mas_len<=1)
			{
				System.out.println("Ошибка ввода: размерность массива не может быть меньше 2!");
				return;
			}
		}
		else
		{
			System.out.println("Ошибка ввода типа данных!");
			return;
		}
		
		System.out.println("Введите "+mas_len+" целых чисел: ");
		int[] mas=new int[mas_len];
		for(int i=0; i<mas_len; i++)
		{
			if(myScanner.hasNextInt())
			{
				mas[i]=myScanner.nextInt();
			}
			else
			{
				System.out.println("Ошибка ввода типа данных!");
				return;
			}
		}
		
		System.out.println("Введенный массив:");
		printMassive(mas);

		//Умножаем на 2 каждый 3-й элемент первым способом
		int factor=2;
		int element_number=3;
		System.out.println("Каждый 3-й элемент умножили на 2:");
		for(int i=0; i<mas.length; i++)
		{
			if(i%element_number==element_number-1)
			{
				mas[i]=mas[i]*factor;
			}
		}
		printMassive(mas);
		
		//Умножаем на 2 каждый 3-й элемент вторым способом
		System.out.println("Каждый 3-й элемент еще раз умножили на 2:");	
		for(int i=element_number-1; i<mas.length; i+=3)
		{
			mas[i]=mas[i]*factor;
		}
		printMassive(mas);
				
	}
	
	public static void printMassive(int[] mas)
	{
		for(int i=0; i<mas.length; i++)
		{
			System.out.print(mas[i]+" ");
		}
		System.out.println();
	}
	
}
