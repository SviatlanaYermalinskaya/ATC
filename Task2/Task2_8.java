package core;

import java.util.Scanner;

// найти минимальный-максимальный элементы и вывести 
public class Task2_8
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
		int left=10;
		int right=100;
		mas=getRandomIntMassive(mas,left,right);
		
		System.out.println("Сгенерированный массив:");
		printMassive(mas);
		
		System.out.println("Минимальное значение массива: "+minMassiveElement(mas));
		System.out.println("Максимальное значение массива: "+maxMassiveElement(mas));
				
	}
	
	// возвращает минимальный элемент массива
	public static int minMassiveElement(int[] mas)
	{
		int min=mas[0];
		for (int i=1; i<mas.length; i++)
		{
			if(mas[i]<min)
			{
				min=mas[i];
			}
		}
		return min;
	}
	
	// возвращает максимальный элемент массива
	public static int maxMassiveElement(int[] mas)
	{
		int max=mas[0];
		for (int i=1; i<mas.length; i++)
		{
			if(mas[i]>max)
			{
				max=mas[i];
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
	
}
