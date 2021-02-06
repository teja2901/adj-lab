package net;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException{
		// TODO Auto-generated method 
				
				Socket s = new Socket("Localhost",2002);
				DataInputStream din = new DataInputStream(s.getInputStream());
				PrintStream pw = new PrintStream(s.getOutputStream());
				
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter string");
				
				String st = sc.nextLine();
				pw.println(st);
				
				
				System.out.println(din.readLine());
				
				s.close();
	}
}