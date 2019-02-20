package core;

import java.util.Scanner;

// найти произведения всех элементов массива, вывести
public class Task2_2
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
		
		double[] mas=new double[mas_len];
		System.out.println("Массив случайных чисел:");
		for(int i=0; i<mas_len; i++)
		{
			mas[i]=Math.random()*10;
			System.out.print(mas[i]+" ");
		}
		System.out.println();
		
		double prod=1;
		int i=0;
		while(i<mas_len)
		{
			prod=prod*mas[i];
			i++;
		}
		System.out.println("Произведение чисел массива: "+prod);
		
	}
}
