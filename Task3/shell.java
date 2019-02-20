package core;

import java.util.Scanner;

/*
 Идея сортировки методом Шелла состоит в том, чтобы сортировать элементы отстоящие друг от друга 
 на некотором расстоянии step. Затем сортировка повторяется при меньших значениях step, и в конце 
 процесс сортировки Шелла завершается при step = 1 (а именно обычной сортировкой вставками).
 
 Шелл предложил такую последовательность: N/2, N/4, N/8 …, где N – количество элементов в сортируемом массиве.

Сортировка Шелла требует около log2N проходов для упорядочивания последовательности длиной N.
 */


public class shell {
	public static void main(String[] arg) {
		
	     int len;
		 len=getMassiveLength(); 
		 
		 int[] mass=new int[len];
	
		 System.out.println("Сгенерированный массив:");
		 mass=getMassive(len);
		 printMassive(mass);
		 
		 System.out.println("Отсортированный массив:");
		 mass=sortShell(mass);
		 printMassive(mass);
	
	}
	
	public static int[] sortShell(int[] mass)
	{
		 int step;
		 int tmp;
		 int step_div=2;
		 for (step = mass.length / step_div; step > 0; step /= step_div)
		 {
			 int j;
		     for (int i = step; i < mass.length; i++)
		     {
		         tmp = mass[i];
		         for (j = i; j >= step; j -= step)
		         {
		             if (tmp < mass[j - step])
		                 mass[j] = mass[j - step];
		             else
		                 break;
		         }
		         mass[j] = tmp;
		     } 
	      }
		 return mass;
		
	}
	
	public static int getMassiveLength()
	{
		 System.out.print("Введите размерность массива:");
		 Scanner in=new Scanner(System.in);
		 int len=in.nextInt();

		 return len;
	}

	public static int[] getMassive(int length)
	{
		 int[] mass=new int[length];
		
		 for(int i=0;i<length;i++)
		 {
		     mass[i]=(int)(Math.random()*100);
		 }		
		return mass;
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

