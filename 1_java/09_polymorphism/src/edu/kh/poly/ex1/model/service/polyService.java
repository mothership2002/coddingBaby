package edu.kh.poly.ex1.model.service;

import edu.kh.poly.ex1.model.vo.Car;
import edu.kh.poly.ex1.model.vo.Spark;
import edu.kh.poly.ex1.model.vo.Tesla;

public class polyService {

	public void ex1() {
		
		Car car = new Car();
		Car car2 = new Tesla();
		Car car3 = new Spark();
		
		Tesla tesla = new Tesla();
		Spark spark = new Spark();
		
		car.setEngine("v v6기통 엔진");
		car.setFuel("휘발유");
		car.setWheel(4);
		
		car2.setEngine("전기 모터");
		car2.setFuel("전기");
		car2.setWheel(4);
		//car2.setBatteryCapacity(8);
		
		car3.setEngine("경차 엔진");
		car3.setFuel("휘발유");
		car3.setWheel(4);
		//car3.setDiscountOffer();
		
		Car[] arr = new Car[3];
		
		arr[0] = car;
		arr[1] = car2;
		arr[2] = car3;
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(i+1+"번째 엔진 : "+ arr[i].getEngine());
		}
		
		
		
		
		
	}
	
	public void ex2() {
		Tesla t = new Tesla("전기 모터","전기",4,10000000);
		Spark s = new Spark("경차 엔진","휘발유",4,0.5);
		Car c = new Car("경유 엔진","경유",12);
		
		
		printCar(t);
		printCar(c);
		printCar(s);
		
		System.out.println("---------------------------------------------------------");
		
		Car[] newCar = {creatCar(1),creatCar(2),creatCar(3)};
		
		System.out.println("=======================================================");
		
		
		for(int i=0;i<newCar.length;i++) {
			//부모타입은 제일 마지막에 검사
			if(newCar[i] instanceof Tesla) {
				System.out.println("Tesla 객체");
			}else if(newCar[i] instanceof Spark) {
				System.out.println("Spark 객체");
			}else {
				System.out.println("Car 객체");
			}
		}
		
		
	}
	//다형성 업케스트 ; 부모타입 참조변수 삽입 , 모든 자식 개체를 전달 받을 수 있음
	public void printCar(Car temp) {
		System.out.println("엔진 : " + temp.getEngine());
		System.out.println("연료 : " + temp.getFuel());
		System.out.println("바퀴 : " + temp.getWheel());
		System.out.println();
		
	}
	
	public Car creatCar(int num) {
		
		Car result = null;
		
		num=(int)(Math.random()*3+1);
		
		switch(num) {
		case 1 : result = new Car(); 
			break;
		case 2 : result = new Tesla();
			break;
		case 3 : result = new Spark();
		}
		
		return result;		
	}
	
	public void ex3() {
		
		//다운케스트
		//부모 타입 참조 변수가 자식 개체를 참조하는 업케스팅 상태에서만 사용 가능
		//부모 타입을 자식 타입으로 강제 형변환
		//자식 객체의 본래 필드 , 메소드에 사용
		
		Car c1 = new Tesla("전기 모터","전기",4,500000);
			
		((Tesla)c1).getBatteryCapacity();
		
		System.out.println(((Tesla)c1).getBatteryCapacity());
		
		Tesla t1 = (Tesla)c1;
		
		
		
	}
	
	public void ex4() {
		//다운케스트 주의사항
		Car c1 = new Spark();
		
//		System.out.println();
//		Spark s1 = (Spark)c1;
		
		//instanceof 사용
		
		if(c1 instanceof Spark) {
			System.out.println("성공");
			Spark s1 = (Spark)c1;
		}else {
			System.out.println("Spark타입이 아니라 실패");
		}
		
	}

	public void ex5() {
		
		Car c1 = new Car();
		
		System.out.println(c1.toString());
		
		Car c2 = new Spark("경차엔진","휘발유",4,0.5);

		System.out.println(c2.toString());
		
		
		
		
	}
	
	
	
}
