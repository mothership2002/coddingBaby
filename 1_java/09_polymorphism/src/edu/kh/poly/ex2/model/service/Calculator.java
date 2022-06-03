package edu.kh.poly.ex2.model.service;

public interface Calculator {

	//������ public static final 
	public static final double PI = 3.14;
	
	static final int MAX_NUM = 1000000000;
	
	int MIN_NUM = -100000;
	
	
	//������ public abstract �߻�޼ҵ�
	
	public abstract int plus(int num1,int num2);

	public abstract int minus(int num1,int num2);
	
	public abstract int multiple(int num1,int num2);
	
	public abstract double divide(int num1,int num2);
	
	
}
