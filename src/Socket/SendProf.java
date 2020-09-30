package Socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class SendProf extends Thread  {
	
	private DatagramSocket dc ;

	public SendProf(DatagramSocket dc) {
		super();
		this.dc = dc;
	}
	
	public void run() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			
		try {
			String msg = in.readLine();
			String tab[] = msg.split("@");
			
			
			if(tab[1].equals("all")) {
				for(Etudiant e:ProfUDP.liste) {
					DatagramPacket pk = new DatagramPacket(tab[2].getBytes(),tab[2].getBytes().length,e.getAdress(),e.getPort());
					dc.send(pk);
				}
			}else {
				
				boolean test = false;
				for(Etudiant e:ProfUDP.liste) {
					if(e.getPseudo().equals(tab[1])) {
						test=true;
						DatagramPacket pk = new DatagramPacket(tab[2].getBytes(),tab[2].getBytes().length,e.getAdress(),e.getPort());
						dc.send(pk);
			}
		}
	}
		}catch (Exception e) {
			// TODO: handle exception
		}

}
}
	}
	
