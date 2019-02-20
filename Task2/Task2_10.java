package core;

import java.util.Scanner;

// проверить, является ли массив возрастающей последовательностью (каждое следующее число больше предыдущего) 
public class Task2_10
{
	public static void main(String[] args) throws InterruptedException
	{
		int min_len=2;
				
		System.out.println("Введите размерность массива (целое число больше или равно "+min_len+"): ");
		Scanner myScanner=new Scanner(System.in);
		int mas_len;
		
		if (myScanner.hasNextInt())
		{
			mas_len=myScanner.nextInt();
			if (mas_len<=1)
			{
				System.out.println("Ошибка ввода: размерность массива не может быть меньше "+min_len+"! Перезапустите программу.");
     			myScanner.close();
				return;
			}
		}
		else
		{
			System.out.println("Ошибка ввода типа данных! Перезапустите программу.");
			myScanner.close();
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
				System.out.println("Ошибка ввода типа данных! Перезапустите программу!");
				return;
			}
		}

		if (isIncreasingSequence(mas))
		{
			System.out.println("Массив является возрастающей последовательностью.");
		}
		else
		{
			System.out.println("Массив не является возрастающей последовательностью.");
		}		
	}
	
	// проверка на возрастающую последовательность
	public static boolean isIncreasingSequence(int[] mas)
	{
		
		for (int i=1; i<mas.length; i++)
		{
			if(mas[i-1]>=mas[i])
			{
				return false;
			}
		}
		return true;
	}
	
}
