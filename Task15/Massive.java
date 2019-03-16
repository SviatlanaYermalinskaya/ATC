package HomeWork;

public class Massive {
	private int [] mass;
	private double average = 0;
	
	Massive (int [] mass)
	{
		this.mass = mass;
		
		if (mass != null)
		{
			this.average = averageValue();
		}
	}
	
	public int[] getMass() 
	{
		return mass;
	}

	public double getAverage() 
	{
		return average;
	}

	public boolean setMassNumber(int index, int number)
	{
		if ((index >= 0)&&(index < mass.length))
		{
			mass[index] = number;
			return true;
		}
		return false;
	}


	// проверка задан ли массив
	public boolean isMassiveLength10()
	{
		if (mass == null)
		{
			return false;
		}
		
		if (mass.length == 10)
		{
			return true;
		}
	
		return false;
	}
	
	// возвращает результат деления элемента массива по указанному индексу index на указанное число devider
	public int devideMassNumberByIndex (int index, int devider)
	{
		return mass[index] / devider; // возможно ArithmeticException
	}
	
	// считаем сумму вскх элементов
	public int sumAllNumbers()
	{
		int result = 0;

		for (int i = 0; i < mass.length; i++)
		{
			result = result + mass[i];
 		}
		return result;
	}	 
	
	public int multiplyMassiveNumbers(int a, int b)
	{
		return mass[a] * mass[b];
	}
	
	public int[] multiplyMassiveOnNumber(int number)
	{
		int[] mass1 = new int[mass.length];
		for (int i = 0; i < mass.length; i++)
		{
			mass1[i] = mass[i] * number;
		}
		return mass1;		
	}
	
	public double averageValue()
	{
		double average_ = 0;
		//NullPointerException for mass[] = null
		
		for (int i = 0; i < mass.length; i++)
		{
			average_ = average_ + mass[i] ;
		}
		
		return average_ / mass.length;
	}
	
	public int[] reverseMassive()
	{
		int[] mass1 = new int[mass.length];
		
		for (int i = 0; i < mass.length; i++)
		{
			mass1[i] = mass[mass.length-1-i];
		}
		
		return mass1;
	}
	
	public int[] sortMassive()
	{	
		int temp;
		
		for (int i = 0; i < mass.length - 1; i++)
		{
			for (int j = 1; j < mass.length - i; j++)
			{
				if (mass[j-1] > mass[j])
				{
					temp = mass[j];
					mass[j] = mass[j-1];
					mass[j-1] = temp;
				}
			}
		}
			
		return mass;
	}
	
	public int min()
	{		
		int min = mass[0];
		
		for (int i = 1; i < mass.length; i++)
		{
			if (min > mass[i])
			{
					min = mass[i];
			}
		}		
		return min;
	}
	

}
