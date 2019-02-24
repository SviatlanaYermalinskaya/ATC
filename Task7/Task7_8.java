package HomeWork;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
 * Ввести n слов с консоли. Среди слов, состоящих только из цифр, найти слово-палиндром. 
 * Если таких слов больше одного, найти второе из них.
 */
public class Task7_8 
{
	public static void main(String[] args) 
	{			
		System.out.println("Введите число слов: ");
		int n = getIntegerMore1();
		
		String[] str = new String[n];
		System.out.println("Введите " +  n + " слов: ");
		str = getWords(str);	
		
		printPalindrom(getWordNumbersOnly(str));
	}
	
	public static List<String> getWordNumbersOnly (String[] str)
	{
		final String NUMBERS_ONLY = "[0-9]*";
		return Arrays.asList(str).stream().filter(name -> (name.matches(NUMBERS_ONLY))).collect(Collectors.toList());
	}
	
	public static void printPalindrom(List<String> list)
	{
		String first_palindrom = "";
		int palindrom_number = 0;
				
		for (String s: list)
		{
			int the_second = 2;
			if (s.equalsIgnoreCase(new StringBuilder(s).reverse().toString()))
			{ 
				palindrom_number++;
				if (palindrom_number == the_second)
				{
					System.out.println("Второй численный палиндром: " + s);
					return;
				}
				first_palindrom = s;
			}
		}
		
		if (palindrom_number == 1)
		{
			System.out.println("Единственный численный палиндром: " + first_palindrom);
			return;
		}

		System.out.println("Численных палиндромов нет");
		
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
