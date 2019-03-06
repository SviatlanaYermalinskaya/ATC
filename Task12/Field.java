package HomeWork;

public class Field {

	private float id;
	private String value;
	
	Field (float id, String value)
	{
		this.id = id;
		this.value = value;
	}

	public float getId() 
	{
		return id;
	}

	public void setId(float id)
	{
		this.id = id;
	}

	public String getValue() 
	{
		return value;
	}

	public void setValue(String value) 
	{
		this.value = value;
	}	
	
	public String toString()
	{
		return  "Field id: " + id + ", value: " + value;
	}	
}
