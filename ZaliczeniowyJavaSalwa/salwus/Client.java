package salwus;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client extends Thread{
	
	static int PortNumber = 1234;
	
	public static void main(String[] args) throws ClassNotFoundException {
		 try {
			Socket sock = new Socket("Machine name", PortNumber);
			ObjectInputStream ois = new ObjectInputStream(sock.getInputStream());
			ObjectOutputStream oos = new ObjectOutputStream(sock.getOutputStream());
			
			TurnAction ta = new TurnAction(2);
			oos.writeObject(ta);
			
			/*while(true){
				TurnAction ta1 = null;
				ta1 = (TurnAction) ois.readObject();
				System.out.println(ta1.buttonPressed);
			}*/
			
			
			//oos.close();
			//ois.close();
			//myClient.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		 
		 
		 
		 
		 
	}
}
