package edu.kh.poly.ex1.model.vo;

public class Tesla extends Car {

	private int batteryCapacity;
	
	public Tesla() {
	
	}

	public Tesla(String engine, String fuel, int wheel, int batteryCapacity) {
		super(engine, fuel, wheel);
		this.batteryCapacity = batteryCapacity;
	}


	public int getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	@Override
	public String toString() {
		return super.toString() + " / " + batteryCapacity; 
	}
	
	
	
	
	
	
}
