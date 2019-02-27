package HomeWork;

public class Sirius extends Star{
	double mass_A = 1.02;
	double mass_B = 0.6;
	
	Sirius()
	{
		super("1.1E31","(H 81.7%, Ge 18.1%)", "2.3E8");
		setName("Сириус");
	}
	
    public void printMassAB ()
    {
    	System.out.println("Масса Сириуса А: " + mass_A + " солнечных масс");
    	System.out.println("Масса Сириуса B: " + mass_B + " солнечных масс");
    }
	
	void printMassSumAB()
	{
		System.out.println("Совокупная масса Сириуса А и Сириуса B составляет " + (mass_A + mass_B) + " солнечных масс");
	}
	
	
	
    public int hashCode()
    {
    	return (int) (mass_A*31 + mass_B*29);
    }	

	public String toString() 
	{
		return getClass().getName() + "@mass_A: " + mass_A + ", mass_B: " + mass_B;
	}

	@Override
	public void printInfo()
	{
		String s = " ";
		System.out.println(getAstronomical_Object()+s + getName() + s + mass + s + chemical_composition + s + age);
	}	

}
