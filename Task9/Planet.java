package HomeWork;

public class Planet extends StarSystem{

	private String mass;
	String atmosphere = "";
	int satellites_number = 0;
	
	// перегруженные связанные друг с другом конструкторы
	Planet()
	{
		setAstronomical_Object("Планета");
	}
	
	Planet (int satellites_number)
	{
		this();
		this.satellites_number = satellites_number;
	}
	
	Planet (String mass, String atmosphere, int satellites_number)
	{
		this(satellites_number);
		this.atmosphere = atmosphere;
		this.mass = mass;
	}
		
	// переопределение абстрактного метода
	@Override
	public void printInfo()
	{
		System.out.println(getAstronomical_Object());
	}

	// гет и сет
	public String getMass() 
	{
		return mass;
	}
	
	public void setMass (String mass)
	{
		this.mass = mass;
	}

	public String getAtmosphere() 
	{
		return atmosphere;
	}

	public int getSatellites_number() 
	{
		return satellites_number;
	}

	public String toString() 
	{
		return getClass().getName() + "@mass: " + mass + ", atmosphere: " + atmosphere + ", satellites_number: " + satellites_number;
	}
	
	public int hashCode()
	{
	    return (int) (((mass == null) ? 0 : mass.hashCode()) + ((atmosphere == null) ? 0 : atmosphere.hashCode()) + 13*satellites_number);
	}
	
	
	
}
