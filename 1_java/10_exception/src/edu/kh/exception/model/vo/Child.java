package edu.kh.exception.model.vo;

import java.io.FileNotFoundException;

public class Child extends Parent{

	@Override
	public void method() throws FileNotFoundException{
		//오버라이딩 - 예외는 일괄적으로 같거나 범위 축소해야함
		//구체적 예외
		
		//Exception 은 IOException 의 부모 class 이므로
		//오버라이딩 불가능
		
		System.out.println("child on override");
	}
	
}
