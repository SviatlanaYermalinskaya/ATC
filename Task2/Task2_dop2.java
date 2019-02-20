package core;

import java.util.ArrayList;

/*
Создать список ArrayList, заполнить его строковыми или числовыми значениями. 
При помощи цикла for each: 
 - вывести все элементы списка
 - к каждому из элементов прибавить любое число (или строку, если список строковый)
 - удалить последовательно все элементы
 - удалить сразу все элементы 
 */
public class Task2_dop2
{
	public static void main(String[] args) 
	{
		ArrayList<String> events = new ArrayList<String>();
		
		// добавление элементов 
		events.add("День рождения");
		events.add("Новый год");
		events.add("Рождество");
		events.add("День влюбленных");
		events.add("8 Марта");
		events.add("День защитника Отечества");
		
		// вывод значений из списка
		for (String str: events)
		{
			System.out.print(str+" ");
		}
		System.out.println();
		
		// добавление к каждому элементу списка строки add_str
		String add_str="!";	
		for (String str: events)
		{
			str=str+add_str;
			System.out.print(str+" ");
		}
		System.out.println();
		
		

		
		/* поэлементная очистка
		for (String str: events)
		{
			events.remove(str);
		}
		*/
		System.out.println("Число элементов списка:"+events.size());
		
		// удаление сразу всех элементов
		events.clear();
		System.out.println("Число элементов после удаления:"+events.size());
		
		events.add("День влюбленных");
		events.add("8 Марта");
		events.add("День защитника Отечества");
		
		// вывод значений из списка
		for (String str: events)
		{
			System.out.print(str+" ");
		}
		System.out.println();
			
		System.out.println("Число элементов списка:"+events.size());
		
		// поэлементное удаление
		for (int i=events.size()-1; i>=0; i--)
		{
			events.remove(i);
		}
		System.out.println("Число элементов после поэлементного удаления:"+events.size());	

	}
	
}
