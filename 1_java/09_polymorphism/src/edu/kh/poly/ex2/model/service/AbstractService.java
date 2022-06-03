package edu.kh.poly.ex2.model.service;

import edu.kh.poly.ex2.model.vo.Animal;
import edu.kh.poly.ex2.model.vo.Fish;
import edu.kh.poly.ex2.model.vo.Person;

public class AbstractService {

	public void ex1() {
//		Animal a1 = new Animal();
		
		Person p1 = new Person();
		
		p1.setType("포유류");
		p1.setEatType("잡식성");
		
		p1.breath();
		p1.eat();
		
		Fish f1 = new Fish();
		
		
		
	}
}
