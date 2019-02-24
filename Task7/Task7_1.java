package HomeWork;

import java.util.Scanner;
/*
 * Ввести n строк с консоли, найти самую короткую и самую длинную строки. Вывести найденные строки и их длину.
 */
public class Task7_1 
{
	public static void main(String[] args) 
	{			
		System.out.println("Введите число строк: ");
		int n = getIntegerMore1();
		
		String[] str = new String[n];
		System.out.println("Введите " +  n + " строк: ");
		str = getStrings(str);
		
		printMinMaxLengthStrings(str);
					
	}
	
	
	public static void printMinMaxLengthStrings(String[] str)
	{
		int min_index = 0;
		int min_value = str[min_index].length();
		
		int max_index = 0;
		int max_value = str[max_index].length();
		
		for (int i=1; i < str.length; i++)
		{
			if (min_value > str[i].length())
			{
				min_value = str[i].length();
				min_index = i;
			}
			if (max_value < str[i].length())
			{
				max_value = str[i].length();
				max_index = i;
			}
		}
		System.out.println("Строка с минимальным числом из "+min_value+" символов: "+str[min_index]);
		System.out.println("Строка с максимальным числом из "+max_value+" символов: "+str[max_index]);
	}
	
	public static String[] getStrings(String[] str)
	{
		Scanner my_scanner = new Scanner(System.in);
		
		for (int i = 0; i < str.length; i++)
		{
			str[i] = my_scanner.nextLine();
		}	
		return str;
	}
	
	public static int getIntegerMore1()
	{
		Scanner my_scanner = new Scanner(System.in);
		if (my_scanner.hasNextInt())
		{
			int len = my_scanner.nextInt();
			if (len>1)
			{
				return len;
			}
			else
			{
				System.out.println("Размерность массива должна быть больше 1. Повторите ввод:");
				return getIntegerMore1();
			}
		}
		else
		{
			System.out.println("Ошибка ввода типа данных. Повторите ввод целого числа:");
			return getIntegerMore1();
		}
	}	
	
}
