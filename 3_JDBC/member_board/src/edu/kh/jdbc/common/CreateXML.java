package edu.kh.jdbc.common;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class CreateXML {

	//XML(eXtensible Markup language) : 단순화된 데이터 기술 형식
	
	public static void main(String[] args) {
		
		//xml은 키/벨류 형식 map, xml은 문자열 
		//Map<String, String> == properties
		
		//properties : String, String 타입제한 MAP
		//			   XML파일 생성 및 읽기 특화
		Properties prop = new Properties();
		
		try {
			FileOutputStream fos = new FileOutputStream("board_sql.xml");
			prop.storeToXML(fos, "Board Service SQL");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
