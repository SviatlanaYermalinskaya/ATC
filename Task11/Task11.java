package HomeWork;

import java.util.Arrays;
import java.util.List;

public class Task11 {

	public static void main(String[] args) {
		
		Button b1 = new Button ("Ok","onClick");
		Button b2 = new Button ("Cancel","onClick");
		Button b3 = new Button ("Find","Action");
		
		Field f1 = new Field(11.0f, "Field1");
		Field f2 = new Field(10.0f, "Field2");
		
		Label l1 = new Label("Label1");
		Label l2 = new Label("Label2");
		Label l3 = new Label("Label3");
		
		List<String> o1 = Arrays.asList(new String[] {"Option1", "Option2", "Option3"});
		List<String> o2 = Arrays.asList(new String[] {"Left", "Right"});
		List<String> o3 = Arrays.asList(new String[] {"Up", "Down"});
		
		Dropdown d1 = new Dropdown (o1, true, "Dropdown1");
		Dropdown d2 = new Dropdown (o2, false, "Dropdown2");
		Dropdown d3 = new Dropdown (o3, true, "Dropdown3");
		
		Page page1 = new Page(1.1f, "Page1");
		
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		
		System.out.println(f1);
		System.out.println(f2);
		
		System.out.println(l1);
		System.out.println(l2);
		System.out.println(l3);
		
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d3);
		
		// Buttons
		page1.addButton(b1);
		page1.addButton(b2);
		page1.addButton(b3);
		page1.printAllButtons();
		
		page1.removeButton(b2);
		page1.printAllButtons();
		
		page1.setButton(1, b2);
		page1.printAllButtons();
		
		// Fields
		page1.addField(f1);
		page1.addField(f2);
		page1.printAllFields();
		
		page1.removeField(f1);
		page1.printAllFields();
		
		page1.setField(0, f1);
		page1.printAllFields();
		
		// Labels
		page1.addLabel(l1);
		page1.addLabel(l2);
		page1.addLabel(l3);
		page1.addLabel(l2);
		page1.printAllLabels();
		
		page1.removeLabel(l2);
		page1.printAllLabels();	
		
		page1.setLabel(l1, l2);
		page1.printAllLabels();
		
		// Dropdowns
		page1.addDropdown(1, d1);
		page1.addDropdown(2, d2);
		page1.addDropdown(3, d3);
		page1.printAllDropdowns();
		
		page1.removeDropdown(2);
		page1.printAllDropdowns();	
		
		page1.setDropdown(1, d2);
		page1.printAllDropdowns();	
		
		// Bubble sort list of buttons		
		page1.addButton(b3);
		page1.addButton(new Button("Ok","Action3"));
		page1.addButton(new Button("Ok","Action2"));
		page1.printAllButtons();
		
		System.out.println("Sorted list of buttons:");
		page1.bubbleSortButtons();	
		page1.printAllButtons();
	}
}
