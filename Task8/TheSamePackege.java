package HomeWork;

/*
 * 7. В методе main другого класса (любого), лежащего в том же пакете что и Tester, создать объект класса Tester, 
 * используя любой из перегруженных конструкторов. 
 * Продемонстрировать последовательный вызов всех методов класса Tester, если это возможно. 
 * Если невозможно - написать комментарий почему. 
 */
public class TheSamePackege {

	public static void main(String[] args) {
		// Создаем объект
		Tester tester1 = new Tester("Алла", "Иванова", 3, "B2", 1300.00);
		tester1.printAll();

		// Доп. задание: так создать нельзя, тк Private конструктор вне зоны видимости
		// Tester tester2 = new Tester("Константин", "Рыбаков");

		// Доп. задание: создание экземпляра класа через вызов статического метода с private конструктором
		Tester tester3 = Tester.newTester("Алина", "Черненко");
		tester3.setName("Алеся");
		tester3.setSurname("Стародубова");
		tester3.printNameSurname();
		tester3.setEnglishLevel("B1");
		tester3.setExperienceInYears(1);
		tester3.setSalary(600.00);
		
		String C = " ";
		System.out.println(tester3.getName()+C+tester3.getSurname()+C+tester3.getEnglishLevel()+C+tester3.getExperienceInYears()+C+tester3.getSalary());

		
		// метод doubleSalary() не может быть вызван , тк он приватный
		// double new_salary = tester3.doubleSalary();
		
		int exp_in_month = tester3.experienceInMonths();
		
	}

}
