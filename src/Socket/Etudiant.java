package Socket;

import java.net.InetAddress;

public class Etudiant {
	
	
	
	private String pseudo;
	private InetAddress adress;
	private int port;
	
	public Etudiant(String pseudo, InetAddress adress, int port) {
		super();
		this.pseudo = pseudo;
		this.adress = adress;
		this.port = port;
	}
	
	
	public Etudiant() {
		super();
	}


	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public InetAddress getAdress() {
		return adress;
	}
	public void setAdress(InetAddress adress) {
		this.adress = adress;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	

}
