package edu.kh.collection.model.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import edu.kh.collection.model.vo.Member;

public class SetService {

	public void ex1() {
		
		Set<String> set = new HashSet<String>();
		//equals, hashCode 오버라이딩 필수
		
		//hash 컬렉션 은 모두
		
		set.add("네이버");
		set.add("카카오");
		set.add("라인");
		set.add("쿠팡");
		set.add("배민");
		set.add("배민");
		set.add(null);
		set.add(null);
		
		
		System.out.println(set);
		System.out.println(set.size());
		
		//hash 포함 set이면 hashcode() 동일해야함
		
		//1. Iterator
		//-컬렉션에서 제공하는 반복접근자
		
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
		
		//object의 equals() , hashcode()
		
		Member mem1 = new Member("user", "pass", 30);
		Member mem2 = new Member("user", "pass", 30);
		Member mem3 = new Member("user3", "pass3", 33);
		
		System.out.println(mem1 == mem2);
		
		if(mem1.getId().equals(mem2.getId())) {
			if(mem1.getPw().equals(mem2.getPw())) {
				if(mem1.getAge()==mem2.getAge()) {
					System.out.println("일치");
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
		//hashcode()오버라이딩 전
		//hashset은 hashcode도 오버라이딩 해야함
		
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
		
		//기울체는 static에 로딩되어있음
		
		System.out.println("=====================");
		
		//parse
		
		int num1 = Integer.parseInt("1000");
		Double num2 = Double.parseDouble("1230.23");
		//문자열 - int변환
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
