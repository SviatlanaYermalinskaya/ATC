package core;


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

	
}
