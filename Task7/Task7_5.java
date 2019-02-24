package HomeWork;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
 * Ввести n слов с консоли. Найти количество слов, содержащих только символы латинского алфавита, 
 * а среди них – количество слов с равным числом гласных и согласных букв.

 */
public class Task7_5 
{
	public static void main(String[] args) 
	{			
		System.out.println("Введите число слов: ");
		int n = getIntegerMore1();
		
		String[] str = new String[n];
		System.out.println("Введите " +  n + " слов: ");
		str = getWords(str);	
		
		List<String> list = getWordsLatinSymbolsOnly(str);
		
		System.out.println("Число слов из латинских символов равно " + getNumberOfWordsLatinSymbolsOnly(list));
		System.out.println("Число слов с одинаковым числом гласных и согласных равно " + getNumberOfWordsVowelsEqualsConsonants(list));

	}
	

	public static List<String> getWordsLatinSymbolsOnly (String[] str)
	{
		final String LATIN_ONLY = "[A-z]+";
		return Arrays.asList(str).stream().filter(name -> (name.matches(LATIN_ONLY))).collect(Collectors.toList());
	}
	
	public static int getNumberOfWordsVowelsEqualsConsonants(List<String> list)
	{

		final String NOT_VOWELS = "[^aeiouAEIOU]";
		final String VOWELS = "[aeiouAEIOU]";				
		int num = 0;
				
		for (String s:list)
		{
			if (s.replaceAll(NOT_VOWELS, "").length() == s.replaceAll(VOWELS, "").length())
			{
				num++;
			}
		}				
		return num;
	}

	
	public static int getNumberOfWordsLatinSymbolsOnly(List<String> list)
	{
		return list.size();
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
