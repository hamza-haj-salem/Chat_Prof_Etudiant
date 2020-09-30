package Socket;

import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Vector;

public class ProfUDP {
	
	static Vector<Etudiant> liste ;

	public static void main(String[] args) throws Exception {
		liste = new Vector<Etudiant>();
		System.out.println("Env de chat creer");
		
		DatagramSocket sc = new DatagramSocket(5000);
		
		RecPROF rec = new RecPROF(sc);
		rec.start();
		
		SendProf se=new SendProf(sc);
		se.start();
		//fama 7aja na9sa 
		
	
	}

}
