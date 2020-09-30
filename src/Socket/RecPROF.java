package Socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class RecPROF extends Thread {
	
	private DatagramSocket sc ;

	public RecPROF(DatagramSocket sc) {
		super();
		this.sc = sc;
	}
	
	public void run() {
		while(true) {
			try {
			DatagramPacket pk = new DatagramPacket(new byte[1024],1024);
			sc.receive(pk);
			InetAddress adr = pk.getAddress();
			int port = pk.getPort();
			
			String msg = new String(pk.getData(),0,pk.getLength()); // 2eme cons de String
			//System.out.println("msg f lawal"+msg);
			
			if(msg.startsWith("$$")) {
				String pseudo= msg.substring(2,msg.length());
				boolean test = false;
				for(Etudiant e:ProfUDP.liste) {
					if(e.getPseudo().equals(pseudo)) {
						test=true;
						
					}
				}
				if(test==true) {
					String msg2 = "Ce nom Existe deja..tu dois le changer";
					DatagramPacket pk2 = new DatagramPacket(msg2.getBytes(),msg2.getBytes().length,adr,port);
					sc.send(pk2);
				}else {
					ProfUDP.liste.add(new Etudiant(pseudo,adr,port));
				}
				
			}else {	
				System.out.println("On a dans Prof, le message de ETD est "+msg);
				System.out.println("On a dans Prof, donner votre reponse : ");
			}
			
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
