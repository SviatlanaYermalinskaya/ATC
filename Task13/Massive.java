package HomeWork;

import java.io.FileOutputStream;
import java.io.IOException;

public class Massive {
	private int [] mass;
	int massLength = 0;
	private double average = 0.0;
	private int multiply = -1;
	
	Massive (int [] mass)
	{
		this.mass = mass;
	}
	
	// 1. try-catch: забиваем массив натуральными числами
	public void setMassWithNumbers()
	{			
		try
		{
			for(int i=0; i<10000; i++)
			{
				mass[i] = i+1;
			}			
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Выход за пределы массива " + e);
	    	for(int i=0; i< Integer.parseInt(e.getMessage()); i++)
			{
				mass[i] = i+1;
			}		
		}
	}
	
	// 2. try-catch-catch:  деление элемента массива по указанному индексу на указанное число 
	public void devideMassNumberByIndex (int index, int devider)
	{
		try
		{
			mass[index] = mass[index] / devider;
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Выход за пределы массива " + e);
			System.out.println("Деление не удалось, выбранный индекс элемента должен быть меньше " + mass.length);
		}
		catch (ArithmeticException e)
		{
			System.out.println("Операция не выполнена. Деление на ноль невозможно " + e);		
		}
	}
	
	// 3. try-multi-catch: считаем произведение num элементов, начиная с элемента с номером index, в случае ошибки возвращаем -1
	public int multiplyAnyNumbers(int num, int index)
	{
		int result = 1;
		try
		{
			for (int i = 0; i < num; i++)
			{
				result = result * mass[index+i];
 			}
		}
		catch (NullPointerException | ArrayIndexOutOfBoundsException ex)
		{
			System.out.println("Ошибка в операции умножения " + ex);
			return -1;
		}
		multiply = result;
		return result;
	}
	 
	// 4. try-catch-finally 
	public void setMassLength(int length)
	{
		mass = new int[massLength];
		try
		{
			if (length < 1)
			{
				throw new NotPositiveMassiveLengthException("Указан размер массива меньше 1 NotPositiveMassiveLengthException: ");
			}
		}
		catch (NotPositiveMassiveLengthException e)
		{
			System.out.println(e.getMessage() + "Размер будет изменен на 10.");
			length = 10;
		}
		finally
		{
			massLength = length;
			mass = new int[massLength];
		}
	}
	
/*
 * Дополнительное задание
 */
	
	// 1. реализовать try with resources в описанном выше классе
	public void writeMassiveToFile(String filePath)
	{
        try( FileOutputStream file_output = new FileOutputStream(filePath)) 
        {
        	for (int i = 0; i < mass.length; i++)
        	{
        		file_output.write(mass[i]);
        	}
        }
        catch(IOException ex) 
        {
            System.out.println("Ошибка записи массива в файл " + ex);
        }
        catch(NullPointerException e)
        {
        	System.out.println("Массив не задан, записанный файл будет пустым " + e);
        }    
	}
	
	// 2. реализовать try внутри try
	public int multiplyAllMassive()
	{
		int result = 1;
		long long_result = 1;
		try
		{
			for (int i = 0; i < mass.length; i++)
			{
				try 
				{
					result = result * mass[i];
					long_result = long_result * mass[i];
					if (long_result != result)
					{
						throw new OutOfIntegerRangeException("OutOfIntegerRangeException: переполнение при умножении на " + i + "-м элементе");
					}
				}
				catch (OutOfIntegerRangeException e)
				{
					System.out.println(e.getMessage() + "\nБудет посчитано произведение только последующих элементов");
					result = 1;
					long_result = 1;
				}
			}		
		}
		catch(NullPointerException e)
		{
			System.out.println("Массив не задан " + e);
			return -1;
		}
		multiply = result;
		return result;
	}
	
	// 3. написать метод с использованием finally, в котором finally вызван не будет
	public void finallyNeverUsed()
	{	
		try
		{
			System.exit(0);
		}
		catch(Exception e)
		{
			System.out.println(e);			
		}
		finally
		{
			System.out.println("Это предложение никогда не будет выведено на экран");
		}
	}	
	
	public double averageValue()
	{
		average = 0;
		try
		{
			for (int i = 0; i < mass.length; i++)
			{
				average = average + mass[i] / mass.length;
			}
		}
		catch(NullPointerException e)
		{
			System.out.println("Массив не задан " + e);
			average = -1;
		}
		return average;
	}
	
	
}
