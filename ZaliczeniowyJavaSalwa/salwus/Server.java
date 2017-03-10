package salwus;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {
	private static int portServer = 9090;
	public static int portPlayer0 = 1234;
	public static int portPlayer1 = 1235;
	
	private static ServerSocket ss;
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		
		
	    try {
	    	ss = new ServerSocket(portPlayer0);
	    	while(true){
	    		Socket s = ss.accept();//czeka dopoki nei zaakceputje
	    		
	    		ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
	    		ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
	    	
	    		TurnAction ta1 = new TurnAction(2);
	    	
	    		oos.writeObject(ta1);
	    	
				ta1 = (TurnAction) ois.readObject();
				System.out.println(ta1.buttonPressed);
				
				Thread t = new Thread(new Runnable(){
					 public void run(){
						 byte[] bRes = new byte[100];
						 ObjectInputStream is;
						 int l;
						 try {
							 is = s.getInputStream();
							 while(true){
								 l = is.read(bRes);
								 System.out.println("odebralem: " + new String(bRes,0,l));
							 }
						 } catch (IOException e) {
							 e.printStackTrace();
						 }
					 }
				});
				t.start();
	    	}
	    	
	    //oos.close();
		//ois.close();
		//ss.close();
	    }
	    catch (IOException e) {
	       System.out.println(e);
	    }
	}
}
	
	
	
	
	
	
	
	
	
	/* private static HashMap<String, Socket> users;
	  
	  
	 public static void main(String[] args) {
	        try (ServerSocket serverSocket = new ServerSocket(portServer)) {
	            System.out.println("log: Server is up and running!");
	            Socket socket;
	            while (true) {
	                socket = serverSocket.accept();
	                System.out.print("log: Someone is trying to join the server...");
	                users.put("Player0", socket);
	                ClientSocket serwer = new ClientSocket(socket);
	                serwer.start();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	 static class ClientSocket extends Thread {
		 Socket socket;
		 private ObjectInputStream objectInputStream;
		 private ObjectOutputStream objectOutputStream;
		 private static HashMap<String, Socket> users;
		 ClientSocket(Socket socket){
			 this.socket = socket;
		 }
		 public void run(){
			 try {
	                while (true) {
	                  
	                       turnAction action = (turnAction) objectInputStream.readObject();
	                       users.get
	                        
	                                     recipientInfo.socket.objectOutputStream.writeObject(message);
	                }
			 }
			 catch(){
				 
			 }
		 }
	 }
	 */
