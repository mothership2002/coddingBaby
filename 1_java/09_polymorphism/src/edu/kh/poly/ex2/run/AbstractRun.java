package edu.kh.poly.ex2.run;

import edu.kh.poly.ex2.model.service.AbstractService;
import edu.kh.poly.ex2.model.service.Calculator;
import edu.kh.poly.ex2.model.service.LDHCalculater;

public class AbstractRun {
	
	public static void main(String[] args) {
		
		AbstractService service = new AbstractService();
		
		service.ex1();
		
		// Calculator ����Ʈ
				// import edu.kh.poly.ex2.model.service.Calculator;
				
				// ���� ���� xxxCalculator ����Ʈ
				// import edu.kh.poly.ex2.model.service.BDHCalculator;
				Calculator cal = new LDHCalculater();
				
				
				System.out.println("�� : " + cal.plus(20, 15));
				System.out.println("�� : " + cal.minus(20, 15));
				System.out.println("�� : " + cal.multiple(20, 15));
				System.out.println("�� : " + cal.divide(20, 15));

	}

}
