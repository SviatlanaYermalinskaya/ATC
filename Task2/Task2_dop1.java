package core;

import java.util.Scanner;

/*
Cоздать двумерный массив, заполнить его случайными числами или вручную. 
Для этого массива: вывести все элементы в прямом и обратном порядке, найти минимальный и максимальный элементы.
 
 */
public class Task2_dop1
{
	public static void main(String[] args) 
	{
		int min_len=2;
		int mas_len=0;
		
		mas_len=getMassiveLength(min_len);
		
		if (mas_len==0)
		{
			System.out.println("Перезапустите программу!");
			return;
		}

		int mas[][]=new int[mas_len][mas_len];
		int left=10;
		int right=100;
		for (int i=0; i<mas.length; i++)
		{
			mas[i]=getRandomIntMassive(mas[i],left,right);
		}
			
		System.out.println("Сгенерированный массив в прямом порядке:");
		for (int i=0; i<mas.length; i++)
		{
			printMassive(mas[i]);
		}
		
		System.out.println("Тот же массив в обратном порядке:");
		for (int i=mas.length-1; i>=0; i--)
		{
			printInvertedMassive(mas[i]);
		}
		
		System.out.println("Минимальный элемент: "+min2dimMassive(mas));
		System.out.println("Максимальный элемент: "+max2dimMassive(mas));	
	}
	
	// Мои методы:
	//Минимальный элемент двумерного массива
	public static int min2dimMassive(int mas[][])
	{
		int min=mas[0][0];
		for (int i=0; i<mas.length; i++)
		{
			for (int j=0; j<mas[i].length; j++)
			{
				if (min>mas[i][j])
				{
					min=mas[i][j];
				}
			}
		}
		return min;
	}
	
	//Максимальный элемент двумерного массива
	public static int max2dimMassive(int mas[][])
	{
		int max=mas[0][0];
		for (int i=0; i<mas.length; i++)
		{
			for (int j=0; j<mas[i].length; j++)
			{
				if (max<mas[i][j])
				{
					max=mas[i][j];
				}
			}
		}
		return max;
	}
		
	
	// возвращает массив целых случайных чисел в диапазоне от a до b-1 для заданного массива mas
	public static int[] getRandomIntMassive(int[] mas, int a, int b)
	{
		for(int i=0; i<mas.length; i++)
		{
			mas[i]=(int)(a+Math.random()*(b-a));
		}
		return mas;
	}
	
	// считывает размерность массива с консоли с проверкой на минимальную длину min_length
	public static int getMassiveLength(int min_length)
	{
		System.out.println("Введите размерность массива (целое число больше или равно "+min_length+"): ");
		Scanner myScanner=new Scanner(System.in);
		int mas_len=0;
		
		if (myScanner.hasNextInt())
		{
			mas_len=myScanner.nextInt();
			if (mas_len<=1)
			{
				System.out.println("Ошибка ввода: размерность массива не может быть меньше "+min_length+"!");
     			myScanner.close();
				return 0;
			}
			else
			{
				myScanner.close();
				return mas_len;
			}
		}
		
		System.out.println("Ошибка ввода типа данных!");
		myScanner.close();
		return 0;		
	}
	
	// выводит массив
	public static void printMassive(int[] mas)
	{
		for(int i=0; i<mas.length; i++)
		{
			System.out.print(mas[i]+" ");
		}
		System.out.println();
	}
	
	// выводит массив в обратном порядке
	public static void printInvertedMassive(int[] mas)
	{
		for(int i=mas.length-1; i>=0; i--)
		{
			System.out.print(mas[i]+" ");
		}
		System.out.println();
	}	
}
