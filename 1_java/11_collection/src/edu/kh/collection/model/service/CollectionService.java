package edu.kh.collection.model.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import edu.kh.collection.model.vo.Student;


public class CollectionService {
	
	private Scanner sc = new Scanner(System.in);
	private List<Student> studentList = new LinkedList<Student>(); //�⺻ũ�� 10ĭ �迭
//  �߰� ���� Ưȭ 
//	private List<Student> studentList = new ArrayList<Student>(); -�˻� Ưȭ

	//arraylist(ũ��)
	//arraylist : java.util.arraylist - list �ڽİ�ü - list�� ĭ ���� ����
	
//	public void ex() {
//		//list test
//		studentList.add(new Student());
//		
//		{Object List.get(index i): }
//		
//		System.out.println(studentList.get(0).toString());
//	
//		if(studentList.get(0) instanceof Student) {
//			System.out.println(((Student)studentList.get(0)).getName());
//		}//- �Ϲ����� �ڵ� (���׸�X)
//		
//		System.out.println(studentList.get(0).getAge()); //-���׸���
//		
//	}
//	
	
	public CollectionService() {
		
		studentList.add(new Student("ȫ�浿", 25, "����� �߱�", 'M', 90));
		studentList.add(new Student("����", 23, "��⵵ �Ȼ��", 'F', 100));
		studentList.add(new Student("�����", 30, "����� ������", 'M', 80));
		studentList.add(new Student("���̳�", 27, "��� û�ֽ�", 'F', 90));
		studentList.add(new Student("������", 24, "���� ���빮��", 'F', 70));
		studentList.add(new Student("�Ƹ���", 24, "�λ�� ������", 'F', 70));
		
	}

	
	/** 
	 * �޴� ��¿� �޼ҵ�
	 * @author �ӵ���
	 */
	public void displayMenu() {
		
		int menuNum = 0 ;
		
		do {
			
			System.out.println("\n===== �л� ���� ���α׷� =====\n");
		
			System.out.println("1. �л� ���� �߰�");
			System.out.println("2. �л� ��ü ��ȸ");
			System.out.println("3. �л� ���� ����");
			System.out.println("4. �л� ���� ����");
			System.out.println("5. �̸����� �˻�");
			System.out.println("6. �ܾ�� �˻�");
			System.out.println("\n0. ���α׷� ����");
			
			System.out.print("\n�޴� ��ȣ : ");
			try{
				menuNum = sc.nextInt();
				
				switch (menuNum) {
				case 1: System.out.println(addStudent());
					break;
				case 2: selectAll();
					break;
				case 3: System.out.println(updateMember());
					break;
				case 4: System.out.println(removeMember());
					break;
				case 5: searchName1();
					break;
				case 6: searchName2();
					break;
				case 0: System.out.println("\n���α׷��� �����մϴ�.");
					break;
				default: System.out.println("\n�ش� ��ȣ�� �޴��� �������� �ʽ��ϴ�. \n�ٽ� �Է��� �ּ���");
				}
				
			}catch(InputMismatchException e ) {
				System.err.println("\n�Է� ������ ��ȿ���� �ʽ��ϴ�.\n�ٽ� �õ����ּ���");
				sc.nextLine();
				menuNum = 10;
			}catch(IndexOutOfBoundsException e) {
				System.err.println("\n�ش� ������ �л��� ��ϵ��� �ʾҽ��ϴ�.");
			}

		}while(menuNum!=0);
		System.out.println();

		
	}
	
	public String addStudent() throws InputMismatchException {
		
		System.out.println("\n===== �л� ���� �߰� =====\n");
		
		System.out.print("�̸� : ");
		String name = sc.next();
		System.out.print("���� : ");
		int age = sc.nextInt();					sc.nextLine();
		System.out.print("��� �� : ");
		String region = sc.nextLine();
		System.out.print("���� (M/F) : ");
		char gender = sc.nextLine().toUpperCase().charAt(0);
		System.out.print("���� : ");
		int score = sc.nextInt();				sc.nextLine();
		
		if(studentList.add(new Student(name, age, region, gender, score))) {
			return "����";
			//add()�� �׻� true
		}else {
			return "����";
		}

		
	}
	
	/** �� ��
	 *  alt shift j
	 */
	public void selectAll() {
		System.out.println();
////	if(studentList.size()==0) {	
//		if(studentList.isEmpty()) {
//			System.out.println("���� �л� ������ ��ϵǾ� ���� �ʽ��ϴ�.");
//			return;
//		}
//		
//		for(int i=0;i<studentList.size();i++) {
//			System.out.println(studentList.get(i));
//		}
		//for each{}
		int index = 0;
		for(Student std:studentList) {
			System.out.print((++index) + "�� : ");
			System.out.println(std);
		}
	}
	
	public String updateMember() throws InputMismatchException,IndexOutOfBoundsException {
		
		System.out.println("\n===== �л� ���� ���� =====\n");
		
		System.out.print("�ε��� ��ȣ �Է� : ");
		int index = sc.nextInt();
		index--;
		sc.nextLine();
		
		if(studentList.isEmpty()) {
			return "\n��� �� �л� ������ �����ϴ�.";
		}else if(index<0) {
			return "\n������ �������� �ʽ��ϴ�.";
		}else if(index>studentList.size()) {
			return "\n������ �Ѿ ���� �Է��� �� �����ϴ�.";
		}else {
			System.out.println(++index + "���� ����� �л� ���� ");
			System.out.println(studentList.get(--index));
			
			System.out.print("�̸� : ");
			String name = sc.next();
			System.out.print("���� : ");
			int age = sc.nextInt();					sc.nextLine();
			System.out.print("��� �� : ");
			String region = sc.nextLine();
			System.out.print("���� (M/F) : ");
			char gender = sc.nextLine().charAt(0);
			System.out.print("���� : ");
			int score = sc.nextInt();				sc.nextLine();
			
			new Student(name, age, region, gender, score);
			Student lastStudent = 
					studentList.set(index, new Student(name, age, region, gender, score));
			
			return lastStudent.getName() + "�л��� ������ ����Ǿ����ϴ�. \n";
			
		}
		
	
	}
	
	public String removeMember() throws IndexOutOfBoundsException {
	
		System.out.println("\n===== �л� ���� ���� =====\n");
		
		System.out.print("���� �� �ε��� ��ȣ �Է� : ");
		int index = sc.nextInt();
		index--;
		sc.nextLine();
		
		if(studentList.isEmpty()) {
			return "\n��� �� �л� ������ �����ϴ�.";
		}else if(index<0) {
			return "\n������ �������� �ʽ��ϴ�.";
		}else if(index>studentList.size()) {
			return "\n������ �Ѿ ���� �Է��� �� �����ϴ�.";
		}else {
			System.err.print("\n�����Ͻðڽ��ϱ�? (Y/N) : ");
			char delet = sc.next().toUpperCase().charAt(0);
			if(delet == 'Y') {
				Student last = studentList.remove(index);
				return "\n" + last.getName() + "�л��� ������ �����Ǿ����ϴ�.";
			}else {
				return "\n��ҵǾ����ϴ�.";
			}
			
		}
		
	}
	
	public void searchName1() {
		
		System.out.println("\n===== �л� �˻� (�̸� ��ġ) =====\n");
		
		System.out.print("�л� �̸� �Է� : " );
		String input = sc.next();
		boolean flag = true;
		System.out.println();
		
		for(Student std : studentList) {
			if(input.equals(std.getName())) {
				System.out.println(std);
				flag = false;
			}
		}
		if(flag) {
			System.out.println("\n�ش� �л��� �Է� �Ǿ����� �ʽ��ϴ�.");
		}
	}

	public void searchName2() {
		System.out.println("\n===== �л� �˻� (�̸� ����) =====\n");
		
		System.out.print("���� ���ڿ� �Է� : " );
		String input = sc.next();
		boolean flag = true;
		System.out.println();
		
		for(Student std : studentList) {
			if(std.getName().contains(input)) {
				System.out.println(std);
				flag = false;
			}
		}
		if(flag) {
			System.out.println("\n�ش� �л��� �Է� �Ǿ����� �ʽ��ϴ�.");
		}
	}
		
	
	
	
}
