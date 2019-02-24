package HomeWork;

import java.util.HashSet;
import java.util.Scanner;

/*
 * Ввести n слов с консоли. Найти слово, состоящее только из различных символов. 
 * Если таких слов несколько, найти первое из них.
 */
public class Task7_7 
{
	public static void main(String[] args) 
	{			
		System.out.println("Введите число слов: ");
		int n = getIntegerMore1();
		
		String[] str = new String[n];
		System.out.println("Введите " +  n + " слов: ");
		str = getWords(str);	
		
		for (String s: str)
		{
			if (hasWordDifferentSymbols(s))
			{
				System.out.println("Первое слово с различными символами: " + s);
				break;
			}
		}
	
	}
	
	public static boolean hasWordDifferentSymbols(String s)
	{
		HashSet<Character> map = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) 
        {
            char ch = s.charAt(i);          
            if (map.contains(ch)) 
            {
                return false;
            } 
            else 
            {
            	 map.add(ch);
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
