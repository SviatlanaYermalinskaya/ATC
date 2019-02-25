package HomeWork;

/*
 * 1. Перегрузить в этом классе 3 конструктора, каждый из которых будет последовательно вызывать другой 
 * используя this(...); Конструктор с наибольшим числом параметров сделать с уровнем доступа отовсюду.

   2. Написать для каждого поля get- и set- методы с уровнем доступа только внутри пакета.

   3. Написать метод с уровнем доступа только внутри класса, который будет возвращать salary*2;
   4. Написать метод с уровнем доступа только внутри пакета, который будет возвращать количество опыта в месяцах;
   5. Написать метод с уровнем доступа внутри пакета и для наследников в других пакетах, который выводит на экран 
   имя и фамилию;
   
   6. Написать метод с уровнем доступа отовсюду, который в одну строку будет выводить всю информацию о пользователе.

 */

public class Tester {

	public String name;
	public String surname;
	protected int experienceInYears;
	String englishLevel;
	private double salary;
	
	// 1 + Доп задание: этот конструктор запрещает создание объекта в других классах без вызова других не private/protected 
	// конструкторов этого класса или статического метода этого класса, помеченного ***
	private Tester(String name, String surname) 
	{
		this.name = name;
		this.surname = surname;
		printNameSurname();
	}	
	
	Tester(String name, String surname, String englishLevel) 
	{
		this(name, surname);
		this.englishLevel = englishLevel;
	}	
	
	public Tester(String name, String surname, int experienceInYears, String englishLevel, double salary) 
	{
		this(name, surname, englishLevel);
    	this.experienceInYears = experienceInYears;
		this.salary = salary;
	}

	// 2
	String getName() 
	{
		return name;
	}

	void setName(String name) 
	{
		this.name = name;
	}

	String getSurname() 
	{
		return surname;
	}

	void setSurname(String surname) 
	{
		this.surname = surname;
	}

	int getExperienceInYears() 
	{
		return experienceInYears;
	}

	void setExperienceInYears(int experienceInYears) 
	{
		this.experienceInYears = experienceInYears;
	}

	String getEnglishLevel() 
	{
		return englishLevel;
	}

	void setEnglishLevel(String englishLevel) 
	{
		this.englishLevel = englishLevel;
	}

	double getSalary() 
	{
		return salary;
	}

	void setSalary(double salary) 
	{
		this.salary = salary;
	}
	
	// 3
	private double doubleSalary()
	{
		final int MULT_2 = 2;
		return MULT_2*this.salary;
	}
	
	// 4
	int experienceInMonths ()
	{
		final int MONTH_NUMBER = 12;
		return MONTH_NUMBER * experienceInYears;
	}

	// 5 
	protected void printNameSurname()
	{
		System.out.println(this.name + " " + this.surname);
	}
	
	// 6 
	public void printAll()
	{
		final String C = " ";
		System.out.println(this.name + C + this.surname + C + this.experienceInYears + C + this.englishLevel + C + this.salary);
	}
	
	// *** Доп. задание: метод для вызова конструктора, запрещенного в других классах
	public static Tester newTester (String name, String surname)
	{
		return new Tester(name, surname);
	}
}
