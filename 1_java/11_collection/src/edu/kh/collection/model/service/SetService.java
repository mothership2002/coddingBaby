package edu.kh.collection.model.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import edu.kh.collection.model.vo.Member;

public class SetService {

	public void ex1() {
		
		Set<String> set = new HashSet<String>();
		//equals, hashCode �������̵� �ʼ�
		
		//hash �÷��� �� ���
		
		set.add("���̹�");
		set.add("īī��");
		set.add("����");
		set.add("����");
		set.add("���");
		set.add("���");
		set.add(null);
		set.add(null);
		
		
		System.out.println(set);
		System.out.println(set.size());
		
		//hash ���� set�̸� hashcode() �����ؾ���
		
		//1. Iterator
		//-�÷��ǿ��� �����ϴ� �ݺ�������
		
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			
			String temp = it.next();
			
			System.out.println(temp);
		}
		
		System.out.println("=======================================");
		
		for(String e : set) {
			System.out.println(e);
		}
	}

	public void ex2() {
		
		//object�� equals() , hashcode()
		
		Member mem1 = new Member("user", "pass", 30);
		Member mem2 = new Member("user", "pass", 30);
		Member mem3 = new Member("user3", "pass3", 33);
		
		System.out.println(mem1 == mem2);
		
		if(mem1.getId().equals(mem2.getId())) {
			if(mem1.getPw().equals(mem2.getPw())) {
				if(mem1.getAge()==mem2.getAge()) {
					System.out.println("��ġ");
				}
			}
		}
		System.out.println("=================================");
		System.out.println(mem1.equals(mem2));
		System.out.println(mem1.equals(mem3));
		System.out.println(mem2.equals(mem3));
	}
	
	public void ex3() {
		
		Set<Member> memberSet = new HashSet<Member>();
		
		memberSet.add(new Member("user1", "pass1", 12));
		memberSet.add(new Member("user2", "pass2", 34));
		memberSet.add(new Member("user3", "pass3", 56));
		memberSet.add(new Member("user4", "pass4", 78));
		memberSet.add(new Member("user4", "pass4", 78));
		memberSet.add(new Member("user5", "pass5", 20));
		
		for(Member mem : memberSet) {
			System.out.println(mem);
		}
		//hashcode()�������̵� ��
		//hashset�� hashcode�� �������̵� �ؾ���
		
		Member mem1 = new Member("user1", "pass1", 30);
		Member mem2 = new Member("user1", "pass1", 30);
		Member mem3 = new Member("user1", "pass1", 31);
		
		System.out.println(mem1.hashCode());
		System.out.println(mem2.hashCode());
		System.out.println(mem3.hashCode());
	}
	
	public void ex4() {
		
		int a = 10;
		double b = 3.14;
		
		Integer iNum = new Integer(a);
		Double dNum = new Double(b);
		
		System.out.println(iNum.MAX_VALUE);
		System.out.println(dNum.MIN_VALUE);
		
		System.out.println(iNum);
		System.out.println(dNum);
		
		Integer a1 = 10;
		
		System.out.println(a1.MIN_VALUE);
		System.out.println(a1);
		
		//���ü�� static�� �ε��Ǿ�����
		
		System.out.println("=====================");
		
		//parse
		
		int num1 = Integer.parseInt("1000");
		Double num2 = Double.parseDouble("1230.23");
		//���ڿ� - int��ȯ
		System.out.println(num1+num2);
		
		
		
	}
	

	
	public void lotto() {

//		Set<Integer> lotto = new HashSet<Integer>();
//		Set<Integer> lotto = new LinkedHashSet<Integer>();
		Set<Integer> lotto = new TreeSet<Integer>();
	
		
		while(lotto.size()<6) {
				
		int random = (int)(Math.random()*45+1);
		
		lotto.add(random);
		
		}
		
		System.out.println(lotto);
		
	}
	
}
