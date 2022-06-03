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
		
		car.setEngine("v v6���� ����");
		car.setFuel("�ֹ���");
		car.setWheel(4);
		
		car2.setEngine("���� ����");
		car2.setFuel("����");
		car2.setWheel(4);
		//car2.setBatteryCapacity(8);
		
		car3.setEngine("���� ����");
		car3.setFuel("�ֹ���");
		car3.setWheel(4);
		//car3.setDiscountOffer();
		
		Car[] arr = new Car[3];
		
		arr[0] = car;
		arr[1] = car2;
		arr[2] = car3;
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(i+1+"��° ���� : "+ arr[i].getEngine());
		}
		
		
		
		
		
	}
	
	public void ex2() {
		Tesla t = new Tesla("���� ����","����",4,10000000);
		Spark s = new Spark("���� ����","�ֹ���",4,0.5);
		Car c = new Car("���� ����","����",12);
		
		
		printCar(t);
		printCar(c);
		printCar(s);
		
		System.out.println("---------------------------------------------------------");
		
		Car[] newCar = {creatCar(1),creatCar(2),creatCar(3)};
		
		System.out.println("=======================================================");
		
		
		for(int i=0;i<newCar.length;i++) {
			//�θ�Ÿ���� ���� �������� �˻�
			if(newCar[i] instanceof Tesla) {
				System.out.println("Tesla ��ü");
			}else if(newCar[i] instanceof Spark) {
				System.out.println("Spark ��ü");
			}else {
				System.out.println("Car ��ü");
			}
		}
		
		
	}
	//������ ���ɽ�Ʈ ; �θ�Ÿ�� �������� ���� , ��� �ڽ� ��ü�� ���� ���� �� ����
	public void printCar(Car temp) {
		System.out.println("���� : " + temp.getEngine());
		System.out.println("���� : " + temp.getFuel());
		System.out.println("���� : " + temp.getWheel());
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
		
		//�ٿ��ɽ�Ʈ
		//�θ� Ÿ�� ���� ������ �ڽ� ��ü�� �����ϴ� ���ɽ��� ���¿����� ��� ����
		//�θ� Ÿ���� �ڽ� Ÿ������ ���� ����ȯ
		//�ڽ� ��ü�� ���� �ʵ� , �޼ҵ忡 ���
		
		Car c1 = new Tesla("���� ����","����",4,500000);
			
		((Tesla)c1).getBatteryCapacity();
		
		System.out.println(((Tesla)c1).getBatteryCapacity());
		
		Tesla t1 = (Tesla)c1;
		
		
		
	}
	
	public void ex4() {
		//�ٿ��ɽ�Ʈ ���ǻ���
		Car c1 = new Spark();
		
//		System.out.println();
//		Spark s1 = (Spark)c1;
		
		//instanceof ���
		
		if(c1 instanceof Spark) {
			System.out.println("����");
			Spark s1 = (Spark)c1;
		}else {
			System.out.println("SparkŸ���� �ƴ϶� ����");
		}
		
	}

	public void ex5() {
		
		Car c1 = new Car();
		
		System.out.println(c1.toString());
		
		Car c2 = new Spark("��������","�ֹ���",4,0.5);

		System.out.println(c2.toString());
		
		
		
		
	}
	
	
	
}
