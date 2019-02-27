package HomeWork;

abstract class StarSystem {

	private String astronomical_object;
	private String name;
	
	// система геттеров и сеттеров
	protected String getAstronomical_Object() 
	{
		return astronomical_object;
	}
	protected void setAstronomical_Object(String astronomical_object) 
	{
		this.astronomical_object = astronomical_object;
	}
    protected String getName() 
    {
		return name;
	}
	protected void setName(String name) 
	{
		this.name = name;
	}

	// абстрактный метод
	abstract public void printInfo();
		
}
