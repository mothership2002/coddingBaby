package edu.kh.poly.ex2.model.vo;

public abstract class Animal {
	
	private String type;
	private String eatType;
	
	public Animal() {	}

	public Animal(String type,String eatType) {
		this.type = type;
		this.eatType = eatType;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public String getEatType() {
		return eatType;
	}

	public void setEatType(String eatType) {
		this.eatType = eatType;
	}
	@Override
	public String toString() {
		return type + " / "+ eatType;
	}
	
	public abstract void eat() ;
	
	public abstract void breath() ;
	
	
	
}
