package core;

import java.util.Scanner;

// пройти по массиву и поменять местами первый и последний, второй и предпоследний и т.д. 
public class Task2_7
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
		int left=11;
		int right=100;
		mas=getRandomIntMassive(mas,left,right);
		
		System.out.println("Сгенерированный массив:");
		printMassive(mas);

		mas=mirrorMassiveChange(mas);
		
		System.out.println("Измененный массив:");
		printMassive(mas);
			
	}
	
	// меняет элементы массива зеркально
	public static int[] mirrorMassiveChange(int[] mas)
	{
		int change_item;
		for (int i=0; i<mas.length/2; i++)
		{
			change_item=mas[i];
			mas[i]=mas[mas.length-i-1];
			mas[mas.length-i-1]=change_item;
		}
		return mas;
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
