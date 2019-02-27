package HomeWork;

public class Sun extends Star{
	
    long surface_temperature = 6000;
    long center_temperature = 15000000;
	
	Sun()
	{
		super("2E30","(H 74%, Ge 23%)", "5.0E9");
		setName("Солнце");
	}
	
	
	
	public void setSurface_Temperature(long surface_temperature) 
	{
		this.surface_temperature = surface_temperature;
	}

	public void setCenter_Temperature(long center_temperature) 
	{
		this.center_temperature = center_temperature;
	}

	public void printSurface_Temperature() 
	{
		System.out.println("Температура поверхности: " + surface_temperature + " К");
	}

	public void printCenter_Temperature() 
	{
		System.out.println("Температура в центре: " + center_temperature + " К");
	}

	
	public String toString() 
	{
		return getClass().getName()+ " @" + "surface_temperature: " + surface_temperature + ", center_temperature: " + center_temperature;
	}

    public int hashCode()
    {
    	return (int) (surface_temperature*31/1000 + center_temperature*29/100000);
    }

	// определение абстрактного метода
	@Override
	public void printInfo()
	{
		String s = " ";
		System.out.println(getAstronomical_Object()+ s + getName() + s + mass + s + chemical_composition + s + age);
	}	
	

}
