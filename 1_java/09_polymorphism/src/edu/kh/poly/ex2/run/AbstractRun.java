package edu.kh.poly.ex2.run;

import edu.kh.poly.ex2.model.service.AbstractService;
import edu.kh.poly.ex2.model.service.Calculator;
import edu.kh.poly.ex2.model.service.LDHCalculater;

public class AbstractRun {
	
	public static void main(String[] args) {
		
		AbstractService service = new AbstractService();
		
		service.ex1();
		
		// Calculator 임폴트
				// import edu.kh.poly.ex2.model.service.Calculator;
				
				// 각자 만든 xxxCalculator 임폴트
				// import edu.kh.poly.ex2.model.service.BDHCalculator;
				Calculator cal = new LDHCalculater();
				
				
				System.out.println("합 : " + cal.plus(20, 15));
				System.out.println("차 : " + cal.minus(20, 15));
				System.out.println("곱 : " + cal.multiple(20, 15));
				System.out.println("몫 : " + cal.divide(20, 15));

	}

}
