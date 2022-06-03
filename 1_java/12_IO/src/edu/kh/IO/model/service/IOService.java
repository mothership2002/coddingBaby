package edu.kh.IO.model.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOService {
	
	//1. file output
	public void output1 () {
		
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("test1.txt");
			String str = "Hello World";
			for(int i=0;i<str.length();i++) {
//				System.out.println(str.charAt(i));
				fos.write(str.charAt(i));
			}
		}catch(IOException e) {	//이게 부모 클래스
		//catch(FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void output2 () {
		
		FileWriter fw = null;
		try {
			fw = new FileWriter("test1.txt");
			String str = "헬로 월드";
			fw.write(str);
			
		}catch(IOException e) {	
			e.printStackTrace();
		}finally{
			try{
				fw.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void input1 () {
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("test1.txt");
			while(true) {
				int data = fis.read();
				if(data == -1) {
					break;
				}
				System.out.print((char)data);
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void input2 () {
		FileReader fr = null;
		try {
			fr = new FileReader("test1.txt");
			while(true) {
				int data = fr.read();
				if(data == -1) {
					break;
				}
				System.out.print((char)data);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fr.close();
			} catch (IOException e) {
			e.printStackTrace();
			}
		}
	}
}
