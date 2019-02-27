package HomeWork;

public class Star extends StarSystem{

	String mass;
	String chemical_composition;
	String age; 
	
	// перегруженные, но не связанные друг с другом конструкторы
	Star()
	{
		setAstronomical_Object("Звезда");		
	}
	Star(String mass, String chemical_composition, String age)
	{
		setAstronomical_Object("Звезда");
		this.mass = mass;
		this.chemical_composition = chemical_composition;
		this.age = age;
	}	
	
	public void printChemicalComposition()
	{
		System.out.println("Химический состав: "+ chemical_composition);
	}
	
	public void printAge()
	{
		System.out.println("Возраст звезды: "+ age);
	}	
	
	
	public int hashCode()
	{
	    return (int) (((mass == null) ? 0 : mass.hashCode()) + ((chemical_composition == null) ? 0 : chemical_composition.hashCode()) + ((age == null) ? 0 : age.hashCode()));
	}

	public String toString() 
	{
		return getClass().getName() + "@mass: " + mass + ", chemical_composition: " + chemical_composition + ", age: " + age;
	}
	
	// переопределение абстрактного метода
	@Override
	public void printInfo()
	{
		System.out.println(getAstronomical_Object());
	}
}
