package net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {

	/**
	 * @param args
	 */
	public static String rev(String st){
		return new StringBuilder(st).reverse().toString();
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DatagramSocket ds=new DatagramSocket(8); 
		byte[] b=new byte[1000];
		DatagramPacket in= new DatagramPacket(b,b.length);  
		System.out.println("Waiting for client's data");
		ds.receive(in);
	
		System.out.println(new String(b));
		String b1 = new String(b).trim();
		
		String st2 = rev(b1);
	
		String b2;
		if(b1.equals(st2)){
			b2 = "yes,it is a palindrome";
		}
		else{
			b2 = "no,not a palindrome";
		}
		
		byte buff[]=b2.getBytes();
		DatagramPacket out= new DatagramPacket (buff,  buff.length,in.getAddress(),in.getPort()); 
		ds.send(out);
		ds.close();
	}

}