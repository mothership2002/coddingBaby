package edu.kh.jdbc.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class LoadXML {
	
	public static void main(String[] args) {
		
		//외부 xml파일 읽어오기
		Properties prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream("driver.xml"));
			System.out.println("driver : "+prop.getProperty("driver"));
			//외부 파일로 데이터 좌표값을 저장해서 실시간 컴파일 리소스 절약
			//db연결정보, sql내용이 빈번한 변화할 예정
			//그 만큼 컴파일 리소스를 잡아먹기 때문
			
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(JDBCTemplate.getConnection());
		
	}
}
