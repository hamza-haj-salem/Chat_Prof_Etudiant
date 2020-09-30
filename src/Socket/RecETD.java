package Socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class RecETD extends Thread {
	
	DatagramSocket ac ;
	String pseudo ;
	public RecETD(DatagramSocket ac, String pseudo) {
		super();
		this.ac = ac;
		this.pseudo = pseudo;
	}
	
	public void run() {
		try {
		while(true) {
			DatagramPacket pk = new DatagramPacket(new byte[1024],1024);
			ac.receive(pk);
			System.out.println("On a dans RecETD,Message du prof : ");
			System.out.println(new String(pk.getData()));
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
