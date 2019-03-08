package HomeWork;

public class Task13 {

	public static void main(String[] args) {
		Massive mass = new Massive (new int[10]);
		
		// заполняем массив натуральными числами
		mass.setMassWithNumbers();
		
		// деление элемента массива по указанному индексу на указанное число 
		mass.devideMassNumberByIndex(2, 0);
		mass.devideMassNumberByIndex(11, 1);
		
		//считаем произведение num элементов, начиная с элемента с номером index, в случае ошибки возвращаем -1
		System.out.println("Результат умножения равен " + mass.multiplyAnyNumbers(3, 1));
		Massive mass1 = new Massive (null);
		System.out.println("Результат умножения равен " + mass1.multiplyAnyNumbers(3, 1));
		System.out.println("Результат умножения равен " + mass.multiplyAnyNumbers(3, 8));
		mass1 = new Massive (new int[] {100000, 200000, 300000}); // при переполнении ошибка не генерируется, можно создать свою OutOfIntegerRangeException
		System.out.println("Результат умножения равен " + mass1.multiplyAnyNumbers(3, 0));
		
		// устанавливаем длинну массива, в случае ошибки создаем массив с 10 элементами 
		mass.setMassLength(-1); // генерируем собственное исключение NotPositiveMassiveLengthException
		
		// Дополнительное задание
		
		// запись массива в файл
		mass = new Massive (null);
		mass.writeMassiveToFile("d:\\output.txt");
		mass1.writeMassiveToFile("");
		
		// находим произведение всех элементов массива, в случае ошибки произведение будет равно -1
		System.out.println("Произведение элементов массива равно " + mass.multiplyAllMassive());
		System.out.println("Произведение элементов массива равно " + mass1.multiplyAllMassive());
		
		mass1.finallyNeverUsed();
		
		// находим среднее значение элементов массива
		System.out.println("Среднее значение элементов массива " + mass.averageValue());

	}

}
