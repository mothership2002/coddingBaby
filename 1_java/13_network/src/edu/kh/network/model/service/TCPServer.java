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
			System.out.println("Ŭ���̾�Ʈ�� ��û�� ��ٸ��� �ֽ��ϴ�.");
			
			clientSocket = serverSocket.accept();
					
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = sdf.format(now);
				
			String clientIP = clientSocket.getInetAddress().getHostAddress();
			
			System.out.println(time);
			System.out.println(clientIP +" ���� �õ�");
			
			is = clientSocket.getInputStream();
			os = clientSocket.getOutputStream();
			
			br = new BufferedReader(new InputStreamReader(is));
			pw = new PrintWriter(os);

			
			pw.println(time + " [���� ���� ����]");
			pw.flush(); //��Ʈ������ ������ �о��
			
			String massage = br.readLine();
			
			System.out.println(clientIP + " : " + massage);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pw != null) pw.close();
				if(br != null) br.close();
				//�������� ������ ��ݵ鵵 ���� ����
				
				if(serverSocket != null) serverSocket.close();
				if(clientSocket != null) clientSocket.close();
				//if���� �߰�ȣ ���� �� ���� �� �ٱ��� �߰�ȣ ���
			} catch(IOException e) {
				e.printStackTrace();
			}

		}
		
		
	}
	
	
}
