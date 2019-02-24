package HomeWork;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Ввести n строк с консоли. Вывести на консоль те строки, длина которых меньше (больше) средней, а также длину.
 */
public class Task7_3 
{
	public static void main(String[] args) 
	{			
		System.out.println("Введите число строк: ");
		int n = getIntegerMore1();
		
		String[] str = new String[n];
		System.out.println("Введите " +  n + " строк: ");
		str = getStrings(str);	
		
		double average_len = getAverageLength(str);
		System.out.println("Средняя длина строк равна "+ average_len);
		
		System.out.println("Строки длинной меньше средней:");
		Arrays.asList(str).stream().filter(s -> (s.length() < average_len)).forEach(s -> System.out.println(s+", длина строки "+s.length()));
		
		System.out.println("Строки длинной больше средней:");
		Arrays.asList(str).stream().filter(s -> (s.length() > average_len)).forEach(s -> System.out.println(s+", длина строки "+s.length()));

	}
	

	public static double getAverageLength(String[] str)
	{
		double average_length=0;
		for (String s: str)
		{
			average_length = average_length + s.length();
		}		
		return average_length/str.length;
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
