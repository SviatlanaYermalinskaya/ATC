package core;

import java.util.Scanner;

// заменить все элементы массива на полусумму соседних элементов
public class Task2_11
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

		int[] mas=new int[mas_len];
		int left=10;
		int right=100;
		mas=getRandomIntMassive(mas,left,right);
		
		System.out.println("Сгенерированный массив:");
		printMassive(mas);
		
		System.out.println("Массив из полусумм соседних элементов:");
		mas=halfSumOfNeighboring(mas);
		printMassive(mas);
	}
	
	// Мои методы:
	// возвращает массив с полусуммами соседних элементов заданного массива
	public static int[] halfSumOfNeighboring(int[] mas)
	{
		int[] new_mas=new int[mas.length];
		for (int i=0; i<mas.length; i++)
		{
			if (i==0)
			{
				new_mas[i]=mas[i+1]/2;
			}
			else
			{
				if (i==mas.length-1)
				{
					new_mas[i]=mas[i-1]/2;
				}
				else
				{
					new_mas[i]=(mas[i-1]+mas[i+1])/2;
				}
			}

		}
		return new_mas;
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
