package edu.kh.network.model.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TCPServer {
	
	public void serverStart() {
		
		int port = 7857;
		
		ServerSocket serverSocket = null;
		Socket clientSocket	= null;
		
		InputStream is = null;
		BufferedReader br = null;
		
		OutputStream os = null;
		PrintWriter pw = null;
		
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("[Server]");
			System.out.println("클라이언트의 요청을 기다리고 있습니다.");
			
			clientSocket = serverSocket.accept();
					
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = sdf.format(now);
				
			String clientIP = clientSocket.getInetAddress().getHostAddress();
			
			System.out.println(time);
			System.out.println(clientIP +" 연결 시도");
			
			is = clientSocket.getInputStream();
			os = clientSocket.getOutputStream();
			
			br = new BufferedReader(new InputStreamReader(is));
			pw = new PrintWriter(os);

			
			pw.println(time + " [서버 접속 성공]");
			pw.flush(); //스트림내부 데이터 밀어내기
			
			String massage = br.readLine();
			
			System.out.println(clientIP + " : " + massage);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pw != null) pw.close();
				if(br != null) br.close();
				//보조들이 닫히면 기반들도 같이 닫힘
				
				if(serverSocket != null) serverSocket.close();
				if(clientSocket != null) clientSocket.close();
				//if문에 중괄호 생략 시 다음 한 줄까지 중괄호 취급
			} catch(IOException e) {
				e.printStackTrace();
			}

		}
		
		
	}
	
	
}
