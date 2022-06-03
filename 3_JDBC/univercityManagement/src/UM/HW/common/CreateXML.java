package UM.HW.common;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class CreateXML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties pt = new Properties();
		
		try {
			FileOutputStream fos = new FileOutputStream("SQL_DML.xml");
			pt.storeToXML(fos, "Univercity Management System");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
