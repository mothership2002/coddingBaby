package edu.kh.poly.ex2.model.vo;

public class Fish extends Animal{

	@Override
	public void eat() {
		System.out.println("주둥이로 먹이를 섭취한다.");
	}

	@Override
	public void breath() {
		System.out.println("아가미로 수중 호흡을 한다.");
	}
	
	

}
