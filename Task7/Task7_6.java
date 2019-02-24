package HomeWork;

import java.util.Scanner;
/*
 * Ввести n слов с консоли. Найти слово, символы в котором идут в строгом порядке возрастания их кодов. 
 * Если таких слов несколько, найти первое из них.
 */
public class Task7_6 
{
	public static void main(String[] args) 
	{			
		System.out.println("Введите число слов: ");
		int n = getIntegerMore1();
		
		String[] str = new String[n];
		System.out.println("Введите " +  n + " слов: ");
		str = getWords(str);	

		boolean check = false;

		for (String s: str)
		{
			check = checkSymbolsAscending(s);
			if (check)
			{
				System.out.println("Первое слово с символами, идущими в строгом порядке возрастания: " + s);				
				break;
			}
		}		
		if (!check)
		{
			System.out.println("Нет слов с символами, идущими в строгом порядке возрастания их кодов.");
		}

	}
	

	public static boolean checkSymbolsAscending(String s)
	{
	
		if (s.length() <= 1)
		{
			return true;
		}
		
		for (int i = 1; i < s.length(); i++)
		{
			if (Character.getNumericValue(s.charAt(i-1)) >= Character.getNumericValue(s.charAt(i)))
			{
				return false;
			}
		}
		
		return true;
	}

	public static String[] getWords(String[] str)
	{
		Scanner my_scanner = new Scanner(System.in);
		
		for (int i = 0; i < str.length; i++)
		{
			str[i] = my_scanner.next();
		}	
		my_scanner.close();
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
