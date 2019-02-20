package HomeWork;

public class Task4_1 {

	public static void main(String[] args) {
		
		String str[] = {"Несовершеннолетний/-яя","Совершеннолетний/-яя"};
		String s = " ";
				
		Person person1 = new Person();
		person1.setName("Оксана");
		person1.setSurname("Иванова");
		person1.printName();
		person1.setAge(19);
		person1.setPhone("+375297473890");
		person1.printAllInformation();
		System.out.println(person1.isAdult() ? str[1] : str[0]);

		Person person2 = new Person();
		person2.setName("Иван");
		person2.setSurname("Орлов");
		person2.setAge(17);
		person2.setPhone("+375257748010");
		System.out.println(person2.getName()+s+person2.getSurname()+s+person2.getAge()+s+person2.getPhone());
		System.out.println(person2.isAdult() ? str[1] : str[0]);
					
	}

}
