package edu.kh.exception.model.vo;

import java.io.FileNotFoundException;

public class Child extends Parent{

	@Override
	public void method() throws FileNotFoundException{
		//�������̵� - ���ܴ� �ϰ������� ���ų� ���� ����ؾ���
		//��ü�� ����
		
		//Exception �� IOException �� �θ� class �̹Ƿ�
		//�������̵� �Ұ���
		
		System.out.println("child on override");
	}
	
}
