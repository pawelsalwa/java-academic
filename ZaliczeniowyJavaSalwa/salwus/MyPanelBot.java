package salwus;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MyPanelBot extends JPanel {
	
	JButton but1 = new JButton("deal 5 dmg, costs 1 mana");
	JButton but2 = new JButton("restore 3 hp, costs 2 mana");
	JButton but3 = new JButton("gain 1 victory point and take 3 dmg");
        
	static JTextArea txtBotHp = new JTextArea();
	static JTextArea txtBotMana = new JTextArea();
	static JTextArea txtBotVP = new JTextArea();
    static JTextArea txtBotLastAction = new JTextArea();
        
    static String output = new String();
	
	JPanel przyciski = new JPanel();
	JPanel napisy = new JPanel();
	
	public GameState gs;
	
	MyPanelBot(GameState gs){
		this.gs = gs;
		leftToThrall();
        rightToThrall();
		napisy();
		
		ImageIcon image;
		if(!gs.player)
			image = new ImageIcon("thrall.jpg");
		else
			image = new ImageIcon("garrosh.jpg");
		JLabel label = new JLabel("", image, JLabel.CENTER);
		this.setLayout(new GridLayout(1,3));
		this.setBackground(Color.GREEN);
		
		this.add(przyciski);
		this.add(label);
		this.add(napisy);	
		
	}
	
	public void leftToThrall(){
		but1.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  System.out.println("1");		       
		         
		         if(gs.player == Run.player){
		        	 
		        	 MyPanelBot.output = "Thrall: deal 5 dmg to Garrosh\n" + MyPanelBot.output;
			         MyPanelBot.txtBotLastAction.setText(MyPanelBot.output);
			         
			         gs.tm -= 1;
			         gs.ghp -= 5;
			         
			         gs.update();
			         MyFrame.actionPerformed = 1;
			         
		         }
	      }
	    });
		
		but2.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  System.out.println("2");
		         if(gs.player == Run.player){
		         
		         MyPanelBot.output = "Thrall: restored 3 hp to himself\n" + MyPanelBot.output;
		         MyPanelBot.txtBotLastAction.setText(MyPanelBot.output);
		         
		         gs.thp += 3;
		         gs.tm -= 2;
		         
		         gs.update();
		         MyFrame.actionPerformed = 2;
		         
		         }
	      }
	    });
		
		but3.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  System.out.println("3");
		         if(gs.player == Run.player){
		        	 
		        	MyPanelBot.output = "Thrall: gained 1 victory point while taking 3dmg\n" + MyPanelBot.output;
		         	MyPanelBot.txtBotLastAction.setText(MyPanelBot.output);
		         
		         	gs.tvp += 1;
		         	gs.thp -= 3;
		         
		         	gs.update();
		         	MyFrame.actionPerformed = 3;
		         }
	      }
	    });
		
		przyciski.setLayout(new GridLayout(6,1));
		przyciski.add(but1);
		przyciski.add(but2);
		przyciski.add(but3);
                
                przyciski.add(txtBotHp);
                przyciski.add(txtBotMana);
                przyciski.add(txtBotVP);
	}
        
        public void rightToThrall(){
        	
            txtBotLastAction.setText(output);
            
            napisy.add(txtBotLastAction);
        }


	public void napisy(){
            
		//console.setText("asdf\nqwer");
		//napisy.add(console);
	}
}