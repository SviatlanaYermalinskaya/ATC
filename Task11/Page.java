package HomeWork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import core.Country;

public class Page {
	private ArrayList<Button> buttonList = new ArrayList<Button>(); 
	private LinkedList<Field> fieldLinkedList = new LinkedList<Field>();
	private HashSet<Label> labelHashSet = new HashSet<Label>();
	private HashMap<Integer, Dropdown> dropdownHashMap = new HashMap<Integer, Dropdown>();
	private float id;
	private String title;
	
	Page(float id, String title)
	{
		this.id = id;
		this.title = title;
	}
	
	public ArrayList<Button> getButtonList() 
	{
		return buttonList;
	}
	public void setButtonList(ArrayList<Button> buttonList) 
	{
		this.buttonList = buttonList;
	}
	public LinkedList<Field> getFieldLinkedList() 
	{
		return fieldLinkedList;
	}
	public void setFieldLinkedList(LinkedList<Field> fieldLinkedList) 
	{
		this.fieldLinkedList = fieldLinkedList;
	}
	public HashSet<Label> getLabelHashSet() 
	{
		return labelHashSet;
	}
	public void setLabelHashSet(HashSet<Label> labelHashSet) 
	{
		this.labelHashSet = labelHashSet;
	}
	public HashMap<Integer, Dropdown> getDropdownHashMap() 
	{
		return dropdownHashMap;
	}
	public void setDropdownHashMap(HashMap<Integer, Dropdown> dropdownHashMap) 
	{
		this.dropdownHashMap = dropdownHashMap;
	}
	public float getId() 
	{
		return id;
	}
	public void setId(float id) 
	{
		this.id = id;
	}
	public String getTitle() 
	{
		return title;
	}
	public void setTitle(String title) 
	{
		this.title = title;
	}

	public boolean addButton(Button b)
	{
		return buttonList.add(b);
	}
	
	public boolean addField(Field f)
	{
		return fieldLinkedList.add(f);
	}
	
	public boolean addLabel(Label l)
	{
		return labelHashSet.add(l);
	}
	
	public void addDropdown(int ind, Dropdown d)
	{
		dropdownHashMap.put(ind, d); 
	}	
	
	public void printAllButtons()
	{
		System.out.println("All buttons:");
		for (Button b: buttonList)
		{
			System.out.println(b.toString());
		}
	}
	
	public void printAllFields()
	{
		System.out.println("All fields:");
		for (Field f: fieldLinkedList)
		{
			System.out.println(f.toString());
		}
	}	
	
	public void printAllLabels()
	{
		System.out.println("All labels:");
		for (Label l: labelHashSet)
		{
			System.out.println(l.toString());
		}
	}		
	
	public void printAllDropdowns()
	{
		System.out.println("All dropdowns:");
		Set<Map.Entry<Integer, Dropdown>> set = dropdownHashMap.entrySet();
		for (Map.Entry<Integer, Dropdown> m: set)
		{
			System.out.println("Key = " + m.getKey() + ", Value = " + m.getValue().toString());
		}
	}	
	
	public String toString()
	{
		return  "Page id: " + id + ", title: " + title;
	}	
	
	public boolean removeButton(Button b)
	{
		 return buttonList.remove(b);
	}
	
	public boolean removeField(Field f)
	{
		return fieldLinkedList.remove(f);
	}
	
	public boolean removeLabel(Label l)
	{
		return labelHashSet.remove(l);
	}	
	
	public void removeDropdown(int key)
	{
		dropdownHashMap.remove(key);
	}		
	
	public void setButton(int index, Button b)
	{
		buttonList.set(index, b);
	}

	public void setField(int index, Field f)
	{
		fieldLinkedList.set(index, f);
	}
	
	public void setLabel(Label l1, Label l2)
	{
		labelHashSet.remove(l1);
		labelHashSet.add(l2);
	}
	
	public void setDropdown(int key, Dropdown d)
	{
		dropdownHashMap.put(key, d);
	}
	
	public int compareButtons(Button b1, Button b2)
	{
		int compare_result = b1.getName().compareTo(b2.getName());
		if (compare_result != 0)
		{
			return compare_result;
		}		
		return b1.getAction().compareTo(b2.getAction());
	}
	
	public boolean bubbleSortButtons()
	{	
		if (buttonList.size() == 0)
			return false;
		Button tmpButton = new Button("", "");
		for (int i = 0; i < buttonList.size()-1; i++)
		{						
			for (int j = 1; j < buttonList.size() - i; j++)
			{
				if (compareButtons(buttonList.get(j-1), buttonList.get(j)) > 0)
				{
					tmpButton = buttonList.get(j-1);
					buttonList.set(j-1, buttonList.get(j));
					buttonList.set(j, tmpButton);				
				}				
			}		
		}
		return true;
		
	}
}
