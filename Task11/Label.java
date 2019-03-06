package HomeWork;

public class Label {

	private String name;
	
	Label (String name)
	{
		this.name = name;
	}
	
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String toString()
	{
		return  "Label name: " + name;
	}	
	
}
