package core;

import java.util.ArrayList;

/*
������� ������ ArrayList, ��������� ��� ���������� ��� ��������� ����������. 
��� ������ ����� for each: 
 - ������� ��� �������� ������
 - � ������� �� ��������� ��������� ����� ����� (��� ������, ���� ������ ���������)
 - ������� ��������������� ��� ��������
 - ������� ����� ��� �������� 
 */
public class Task2_dop2
{
	public static void main(String[] args) 
	{
		ArrayList<String> events = new ArrayList<String>();
		
		// ���������� ��������� 
		events.add("���� ��������");
		events.add("����� ���");
		events.add("���������");
		events.add("���� ����������");
		events.add("8 �����");
		events.add("���� ��������� ���������");
		
		// ����� �������� �� ������
		for (String str: events)
		{
			System.out.print(str+" ");
		}
		System.out.println();
		
		// ���������� � ������� �������� ������ ������ add_str
		String add_str="!";	
		for (String str: events)
		{
			str=str+add_str;
			System.out.print(str+" ");
		}
		System.out.println();
		
		

		
		/* ������������ �������
		for (String str: events)
		{
			events.remove(str);
		}
		*/
		System.out.println("����� ��������� ������:"+events.size());
		
		// �������� ����� ���� ���������
		events.clear();
		System.out.println("����� ��������� ����� ��������:"+events.size());
		
		events.add("���� ����������");
		events.add("8 �����");
		events.add("���� ��������� ���������");
		
		// ����� �������� �� ������
		for (String str: events)
		{
			System.out.print(str+" ");
		}
		System.out.println();
			
		System.out.println("����� ��������� ������:"+events.size());
		
		// ������������ ��������
		for (int i=events.size()-1; i>=0; i--)
		{
			events.remove(i);
		}
		System.out.println("����� ��������� ����� ������������� ��������:"+events.size());	

	}
	
}
