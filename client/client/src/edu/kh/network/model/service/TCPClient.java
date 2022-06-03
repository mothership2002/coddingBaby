package edu.kh.network.model.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClient {

	public void clientStart() {
		
		String serverIP = "127.0.0.1";
		//127.0.0.1 loopback ip
		
		int port = 7857;
		
		Socket clientSocket = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			System.out.println("[Clinet]");
			clientSocket = new Socket(serverIP,port);
			
			br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			pw = new PrintWriter(clientSocket.getOutputStream());
			
			String massage = br.readLine();
			System.out.println(massage);
			
			Scanner sc = new Scanner(System.in);
			System.out.print("�Է� : ");
			String input = sc.nextLine();
			
			pw.println(input);
			pw.flush();
			
		} catch (Exception e) {
//			(UnknownHostException,IOException)
			e.printStackTrace();
		} finally {
			try {
				if(pw != null) pw.close();
				if(br != null) br.close();
				if(clientSocket != null) clientSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	
}
