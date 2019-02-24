package HomeWork;

import java.util.Scanner;
/*
 * Ввести n строк с консоли. Упорядочить и вывести строки в порядке возрастания (убывания) значений их длины.
 */
public class Task7_2 
{
	public static void main(String[] args) 
	{			
		System.out.println("Введите число строк: ");
		int n = getIntegerMore1();
		
		String[] str = new String[n];
		System.out.println("Введите " +  n + " строк: ");
		str = getStrings(str);		

		System.out.println("Вывод строк в порядке возрастания длин строк:");
		printStrings(sortInAscendingStringLength(str));
		
		System.out.println("Вывод строк в порядке убывания длин строк:");
		printStrings(sortInDescendingStringLength(str));							
	}
	
	
	
	public static String[] sortInAscendingStringLength(String[] str)
	{
		String s;
		
		for (int j = str.length; j>1; j--)
		{
			for (int i = 1; i < j; i++)
			{
			    if (str[i].length() < str[i-1].length())
			    {
			    	s = str[i];
			    	str[i] = str[i-1];
			    	str[i-1] = s;
			    }
			}
		}
		return str;
	}
	
	public static String[] sortInDescendingStringLength(String[] str)
	{
		String s;
		str = sortInAscendingStringLength(str);
		for (int i = 0; i < str.length/2; i++)
		{
			s = str[i];
			str[i] = str[str.length-i-1];
			str[str.length-i-1] = s;
		}
		
		return str;
	}
	
	public static String[] getStrings(String[] str)
	{
		Scanner my_scanner = new Scanner(System.in);
		
		for (int i = 0; i < str.length; i++)
		{
			str[i] = my_scanner.nextLine();
		}	
		my_scanner.close();
		return str;
	}
	
	public static void printStrings(String[] str)
	{
		for (String s:str)
		{
			System.out.println(s);
		}
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
