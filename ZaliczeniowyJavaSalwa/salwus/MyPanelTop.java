package salwus;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MyPanelTop extends JPanel {
	
	JPanel napisy = new JPanel();
	JPanel save = new JPanel();
	
	JButton butSave = new JButton("save");
	JButton butLoad = new JButton("load");
	public GameState gs;
        
        static JTextArea txtTopHp = new JTextArea();
        static JTextArea txtTopMana = new JTextArea();
        static JTextArea txtTopVP = new JTextArea();
        JTextArea txtTopLastAction = new JTextArea();
	
	MyPanelTop(GameState gs){
		this.gs=gs;
		ImageIcon image;
		if(gs.player)
			image = new ImageIcon("thrall.jpg");
		else
			image = new ImageIcon("garrosh.jpg");
		JLabel label = new JLabel("", image, JLabel.CENTER);
		this.setLayout(new GridLayout(1,3));
		
		this.przyciski();
        this.save();
		
		this.add(napisy);
		this.add( label );
		this.add(save);
	
		
		
	}
	
	void przyciski(){
                   // txtTopHp.setText("Health:" + gs.ghp);
                   // txtTopMana.setText("Mana: " + gs.gm);
                    //txtTopVP.setText("Victory Points:" + gs.gvp);            
                    
                    napisy.setLayout(new GridLayout(6,1));
                    napisy.add(txtTopHp);
                    napisy.add(txtTopMana);
                    napisy.add(txtTopVP);
	}
                
	void save(){
		butSave.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  System.out.println("Saving...");
	    	  MyPanelBot.output = "Saving...\n" + MyPanelBot.output;
		      MyPanelBot.txtBotLastAction.setText(MyPanelBot.output);
		      
		        GameState gsave = gs;
		        
		        FileOutputStream fos = null;
		        ObjectOutputStream oos = null;

		        try {
		          fos= new FileOutputStream("save.ser"); //utworzenie strumienia wyjœciowego
		          oos = new ObjectOutputStream(fos);  //utworzenie obiektu zapisuj¹cego do strumienia
		          
		          oos.writeObject(gsave); //serializacja obiektu
		          
		        } catch (FileNotFoundException e1) {
		          e1.printStackTrace();
		        } catch (IOException e1) {
		          e1.printStackTrace();
		        } finally {
		          // zamykamy strumienie w finally
		          try {
		            if (oos != null) oos.close();
		          } catch (IOException e1) {}
		          try {
		            if (fos != null) fos.close();
		          } catch (IOException e1) {}
		        }
		        System.out.println("Game saved.");
		        MyPanelBot.output = "Game saved.\n" + MyPanelBot.output;
			    MyPanelBot.txtBotLastAction.setText(MyPanelBot.output);
	      }
	    });
		
		butLoad.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  System.out.println("Loading...");
	    	  MyPanelBot.output = "Loading...\n" + MyPanelBot.output;
			  MyPanelBot.txtBotLastAction.setText(MyPanelBot.output);
		        
		        GameState gsave = null;		      
		        FileInputStream fis = null;
		        ObjectInputStream ois = null;
		        try {
		          fis = new FileInputStream("save.ser"); //utworzenie strumienia wejœciowego  
		          ois = new ObjectInputStream(fis); //utworzenie obiektu odczytuj¹cego obiekty ze strumienia
		          
		          gsave = (GameState) ois.readObject(); //deserializacja obiektu
		        
		        } catch (FileNotFoundException e1) {
		          e1.printStackTrace();
		        } catch (IOException e1) {
		          e1.printStackTrace();
		        } catch (ClassNotFoundException e1) {
		          e1.printStackTrace();
		        } finally {
		          // zasoby zwalniamy w finally
		          try {
		            if (ois != null) ois.close();
		          } catch (IOException e1) {}
		          try {
		            if (fis != null) fis.close();
		          } catch (IOException e1) {}
		        }
		        Run.mf0.gs.ghp= gsave.ghp;
		        Run.mf0.gs.gm= gsave.gm;
		        Run.mf0.gs.gvp= gsave.gvp;
		        
		        Run.mf0.gs.thp= gsave.thp;
		        Run.mf0.gs.tm= gsave.tm;
		        Run.mf0.gs.tvp= gsave.tvp;
		        
		        Run.mf0.gs.output= gsave.output;
		        Run.mf0.gs.turn= gsave.turn;
		        Run.mf0.gs.winner= gsave.winner;
		        
		        gsave.update();
		        System.out.println("Game loaded.");
		        MyPanelBot.output = "Game loaded.\n" + MyPanelBot.output;
			    MyPanelBot.txtBotLastAction.setText(MyPanelBot.output);
	      }
	    });
		
        save.add(butSave); 
        save.add(butLoad); 
	}
}