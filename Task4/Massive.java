package HomeWork;

public class Massive {

	public void printMassiveAsLine(double[] mass)
	{
		for (int i = 0; i < mass.length; i++)
		{
			System.out.print(mass[i] + " ");
		}
		System.out.println();
	}
	
	public void printReverseMassiveAsLine(double[] mass)
	{
		for (int i = mass.length-1; i >= 0; i--)
		{
			System.out.print(mass[i] + " ");
		}
		System.out.println();
	}

	public double getSumOfElements(double[] mass)
	{
		double sum = 0;
		for (int i = 0; i < mass.length; i++)
		{
			sum = sum + mass[i];
		}
		return sum;
	}
	
	public double[] multiptyBy3(double[] mass)
	{
		int NUM_3 = 3;
		for (int i = 0; i < mass.length; i++)
		{
			mass[i] = mass[i] * NUM_3;
		}
		return mass;
	}	
}
