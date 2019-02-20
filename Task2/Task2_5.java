package core;

import java.util.Scanner;

// найти и вывести номер нулевых элементов. если нулевых элементов нет - вывести сообщение, что их нет  
public class Task2_5
{
	public static void main(String[] args) throws InterruptedException
	{
		int min_len=2;
		int mas_len=0;
		
		mas_len=getMassiveLength(min_len);
		
		if (mas_len==0)
		{
			System.out.println("Перезапустите программу!");
			return;
		}

		int[] mas=new int[mas_len];
		int mult=5;
		mas=getRandomIntMassive(mas,0,mult);
		
		System.out.println("Сгенерированный массив:");
		printMassive(mas);

		int count_zero;
		System.out.print("Номера нулевых элементов");
		count_zero=printZeroIndexes(mas);
		if (count_zero==0)
		{
			System.out.println(" отсутствуют.");
		}
		else
		{
			System.out.println(".");
		}
			
	}
	
	
	// считает нулевые элементы массива
	public static int printZeroIndexes(int[] mas)
	{
		int count_zero=0;
		for(int i=0; i<mas.length; i++)
		{
			if (mas[i]==0)
			{
				System.out.print(" "+i);
				count_zero++;
			}
		}
		return count_zero;
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
	
	public static void printMassive(int[] mas)
	{
		for(int i=0; i<mas.length; i++)
		{
			System.out.print(mas[i]+" ");
		}
		System.out.println();
	}
	
}
