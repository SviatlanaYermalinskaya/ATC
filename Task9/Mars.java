package HomeWork;

public class Mars extends Planet{
	final int RADIUS = 3390;
	int height = 0;
	
	Mars ()
	{
		super("6.39E23", "(CO2, N2)", 2);
		setName("Марс");		
	}	
	
	public void setHeight (int h)
	{
		this.height = h;
	}
	public int getHeightFromCenter()
	{
		return height + RADIUS;
	}
	public int getHeightFromCenter(int h)
	{
		return h + RADIUS;
	}

	
	
	
	public String toString() 
	{
		return getClass().getName() + "@RADIUS: " + RADIUS + ", height: " + height;
	}

	public int hashCode()
	{
	  	return (int) (RADIUS*31/100 + height*29);
	}		
	
	// переопределение абстрактного метода
	@Override
	public void printInfo()
	{
		String s = " ";
		System.out.println(getAstronomical_Object() + s + getName() + s + getMass() + s + getAtmosphere() + s + getSatellites_number());
		System.out.println("Радиус Марса:" + RADIUS);
	}	

}
