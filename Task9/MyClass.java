package HomeWork;

public class MyClass {

	public static void main(String[] args) {
		
		Planet pl1 = new Planet ();
		pl1.printInfo();
	    System.out.println(pl1.toString());
	    System.out.println(pl1.hashCode());	
	    
		Planet pl2 = new Earth();
		pl2.printInfo();
	    System.out.println(pl2.toString());
	    System.out.println(pl2.hashCode());				
		
		Planet pl3 = new Mars();
		pl3.printInfo();
	    System.out.println(pl3.toString());
	    System.out.println(pl3.hashCode());				
		
		
		Earth earth = (Earth) pl2;
		int h1 = 167;
		int h2 = 48000;
		System.out.println("Число полных земных дней в 167 часах равно " + earth.fullDaysByHours(h1));
		System.out.println("Число полных земных лет в 48000 часах равно " + earth.fullYearsByHours(h2));
	    System.out.println(earth.toString());
	    System.out.println(earth.hashCode());		

	    Mars mars1 = (Mars) pl3;
	    System.out.println("Расстояние от объекта на поверхности до центра Марса равно " + mars1.getHeightFromCenter(0));
	    int height = 1200;
	    mars1.setHeight(height);
	    System.out.println("Расстояние от объекта на высоте 1200 до центра Марса равно " + mars1.getHeightFromCenter());
	    System.out.println(mars1.toString());
	    System.out.println(mars1.hashCode());	    
				
		Star s1 = new Star();
		s1.printInfo();
	    System.out.println(s1.toString());
	    System.out.println(s1.hashCode());	    		
		Star s2 = new Sirius();
		s2.printInfo();
		s2.printChemicalComposition();
		Star s3 = new Sun();
		s3.printInfo();	
		s3.printAge();
		
	    Sirius sirius = new Sirius();
	    sirius.printMassAB();
	    sirius.printMassSumAB();
	    System.out.println(sirius.toString());
	    System.out.println(sirius.hashCode());
	    
	    Sun sun = new Sun();
	    sun.printInfo();
	    sun.printCenter_Temperature();
	    sun.printSurface_Temperature();
	    System.out.println(sun.toString());
	    System.out.println(sun.hashCode());
	    
	

	}

}
