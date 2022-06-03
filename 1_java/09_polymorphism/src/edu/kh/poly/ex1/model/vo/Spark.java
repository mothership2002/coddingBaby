package edu.kh.poly.ex1.model.vo;

public class Spark extends Car{

	private double discountOffer;
	
	public Spark() {
		super();
	}

	public Spark(String engine, String fuel, int wheel, double discountOffer) {
		super(engine, fuel, wheel);
		this.discountOffer = discountOffer;
	}

	public double getDiscountOffer() {
		return discountOffer;
	}

	public void setDiscountOffer(double discountOffer) {
		this.discountOffer = discountOffer;
	}
	
	@Override
	public String toString() {
		
		return super.toString()+" / "+ discountOffer;
	}
	
	
	
	
}
