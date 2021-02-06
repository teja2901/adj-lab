package net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPClient {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
			InetAddress ia=InetAddress.getLocalHost(); 
			DatagramSocket ds=new DatagramSocket (2001,ia);
			System.out.println("Enter String:");
			Scanner sc = new Scanner(System.in);
			String x = sc.nextLine();
			byte[] b=x.getBytes();
			DatagramPacket dp = new DatagramPacket(b, b. length, ia,8);  ds.send(dp);
			System.out.println("sending to server: "+(new String(b)));
			byte[] buff=new byte[1000];
			DatagramPacket in = new DatagramPacket(buff, buff.length);  ds.receive(in);
			System.out.println("recieved from server: "+(new String(buff)));
			ds.close();
			
		

		}
		

	}

