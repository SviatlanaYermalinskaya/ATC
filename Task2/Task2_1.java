package core;

import java.util.Scanner;

//пройти по массиву, вывести все элементы в прямом и в обратном порядке
public class Task2_1 
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
		
		System.out.println("Введите "+mas_len+" вещественных чисел: ");
		double[] mas=new double[mas_len];
		for(int i=0; i<mas_len; i++)
		{
			if(myScanner.hasNextDouble())
			{
				mas[i]=myScanner.nextDouble();
			}
			else
			{
				System.out.println("Ошибка ввода типа данных!");
				return;
			}
		}
		
		System.out.println("Массив в прямом порядке:");
		for(int i=0; i<mas_len; i++)
		{
			System.out.print(mas[i]+" ");
		}
		System.out.println();
		
		System.out.println("Массив в обратном порядке:");
		int i=mas_len-1;
		while(i>=0)
		{
			System.out.print(mas[i]+" ");
			i--;
		}
		
	}
}
