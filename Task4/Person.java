package HomeWork;

public class Person {

	String name;
	String surname;
	int age;
	String phone;
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setSurname(String surname)
	{
		this.surname = surname;
	}
	
	public String getSurname()
	{
		return this.surname;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public int getAge()
	{
		return this.age;
	}
		
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	
	public String getPhone()
	{
		return this.phone;
	}
		
	public boolean isAdult()
	{
		return this.age>=18;
	}
	
	public void printName()
	{
		System.out.println(name+" "+surname);
	}
	
	public void printAllInformation()
	{
		String s=" ";
		System.out.println(name+s+surname+s+age+s+phone);
	}
	
}
