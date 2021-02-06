package net;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static String rev(String s){
		return new StringBuilder(s).reverse().toString();
	}
	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
	
			
			ServerSocket ss = new ServerSocket(2002);
			System.out.println("Server is ready for clients");
			Socket client = ss.accept();
			
			DataInputStream din = new DataInputStream(client.getInputStream());
			PrintStream pw = new PrintStream(client.getOutputStream());
			
			
			String st = din.readLine();
			
			System.out.println("String is"+st);
			String st2 = rev(st);
			String b;
			if(st2.equals(st)){
				b = "yes,it is!!";
			}
			else{
				b = "Not a palindrome";
			}
	
			pw.println("Palindrome:"+b);
			
			client.close();
		

	}

}