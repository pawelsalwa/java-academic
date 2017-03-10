package salwus;

import java.awt.GridLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
	
//=================================================================================================
public class MyFrame extends JFrame implements Runnable {
	
	public Socket socket;
	public int asd =0;
	public static int actionPerformed;
	public String nazwa;
	public String nazwaWroga;
	public int port;
	public int portWroga;
	public static GameState gs = new GameState();
	
	ObjectInputStream ois;
	ObjectOutputStream oos;
	
	ServerSocket serverSocket;
//=========================KONSTRUKTOR====================================================	
	public MyFrame(Boolean player){
		super("The Duel");
		gs.player = player;
		gs.turn = player;
		gs.update();
		actionPerformed = 0;
		
		if(player){
			nazwa = "p1";//garrosh gdy arg0 = true
			port = 501;
			nazwaWroga = "p0";
			portWroga = 500;
		}
		else{
			nazwa = "p0";//thrall gdy arg0 = false
			port = 500;
			nazwaWroga = "p1";
			portWroga = 501;
		}
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800, 500);
		this.setVisible(true);
		
		GameState gs = new GameState();
		MyPanelTop mpt = new MyPanelTop(this.gs);
		MyPanelBot mpb = new MyPanelBot(this.gs);
		
		this.setLayout(new GridLayout(2,1));
		this.add(mpt);
		this.add(mpb);
		//this.pack();
		
		Thread t = new Thread(this, "thread");
		
		connect();
		initServer();
		t.start();
	}
//============================run======================================	
	public void run() {
        System.out.println("GameState.player: " + gs.player);
        System.out.println("Run.player: " + Run.player);
        while(true){
        	//System.out.println("actPerf: " + actionPerformed);
        	checkEnd();
        	if (actionPerformed !=0 && gs.turn == Run.player ){
        		
        		System.out.println("sending");
        		sendAction(actionPerformed);
        		gs.turn = !gs.turn ;
        	}
        	
        	if(gs.turn != Run.player){
        		listenForServerRequest();
        		readAction();
        		
        	}
        }
	}
	
	
private void checkEnd() {
		if(this.gs.ghp < 1 || this.gs.gm < 1){
			MyPanelBot.output = "GAME FINISHED- Thrall wins\n" + MyPanelBot.output;
	        MyPanelBot.txtBotLastAction.setText(MyPanelBot.output);
		}
		if(this.gs.thp < 1 || this.gs.tm < 1){
			MyPanelBot.output = "GAME FINISHED- Garrosh wins\n" + MyPanelBot.output;
	        MyPanelBot.txtBotLastAction.setText(MyPanelBot.output);
		}
	}
	//============================read======================================	
	public void readAction(){
		
		TurnAction ta = null;
		
		try {
			ta = (TurnAction) ois.readObject();
			gs.turn = !gs.turn;
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		switch(ta.buttonPressed){
			case 1:
				gs.tm -= 1;
		        gs.ghp -= 5;
		        
		        gs.update();
				break;
		}
	}
//============================send======================================
	public void sendAction(int nrAkcji) {
		TurnAction ta = new TurnAction(nrAkcji);
		try {
			oos.writeObject(ta);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void connect(){
		try {
			socket = new Socket(nazwaWroga, portWroga);
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
        }catch (IOException e){
        }
	}
	
	private void listenForServerRequest() {
        Socket socket = null;
        try {
        	System.out.println("waiting for socket input");
            socket = serverSocket.accept();//czeka na polaczenie
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public void updateGS(GameState gs){
		this.gs = gs;
	}
	
	private void initServer() {
        try {//klasa reprezentujaca gniazdo oczekujace na przychodzace zadania polaczen
        	serverSocket = new ServerSocket(port, 8 , InetAddress.getByName(nazwa));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	
}
