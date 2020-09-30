package Socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;



public class EtdUDP {

	public static void main(String[] args) throws Exception {
		
		DatagramSocket sc = new DatagramSocket();
		InetAddress adr = InetAddress.getLocalHost();
		
		System.out.println("Espace ETD .. Donner votre nom sous la forme :  $$---");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String pseudo="";
		do {
			pseudo=in.readLine();
		}while(!pseudo.startsWith("$$"));
		
		System.out.println("Donner votre msg : ");
		DatagramPacket pk = new DatagramPacket(pseudo.getBytes(),pseudo.getBytes().length,adr,5000);
		sc.send(pk);
		
		pseudo = pseudo.substring(2,pseudo.length());
		SendETD send = new SendETD(sc, pseudo);
		send.start();
		
		RecETD rec = new RecETD(sc, pseudo);
		rec.start();
		

	}

}
