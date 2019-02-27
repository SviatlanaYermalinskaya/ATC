package HomeWork;

public class Earth extends Planet{
	static int num = 0;
	final int HOURS_A_DAY = 24;
	final int DAYS_A_YEAR = 365;
	 	
	Earth ()
	{
		super("5.972E24", "(N2, O2)", 1);
		setName("Земля");	
		num++;
	}
	
	public int fullDaysByHours (int hours)
	{
		return hours / HOURS_A_DAY;
	}
	
	public int fullYearsByHours (int hours)
	{
		return hours / HOURS_A_DAY / DAYS_A_YEAR;
	}
		
	
	
	public int hashCode()
	{
	  	return (int) (HOURS_A_DAY*31 + DAYS_A_YEAR*29 + num * 53);
	}	
	public String toString() 
	{
		return getClass().getName() + "@num: "+ num + ", HOURS_A_DAY: " + HOURS_A_DAY + ", DAYS_A_YEAR: " + DAYS_A_YEAR;
	}

	// переопределение абстрактного метода
	@Override
	public void printInfo()
	{
		String s = " ";
		System.out.println("Номер объекта Земля: "+ num);
		System.out.println(getAstronomical_Object() + s + getName() + s + getMass() + s + getAtmosphere() + s + getSatellites_number());
	}	

}
