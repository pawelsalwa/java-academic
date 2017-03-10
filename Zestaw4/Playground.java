package watki;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class Playground extends JFrame implements ActionListener {
	
	public MyPanel mp;
	
	public Playground(){
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 400);
		this.setLayout(null);
		
		JButton but = new JButton("nowa kulka");
		but.addActionListener(this);
		but.setBounds(10,10,90,20);
		this.add(but);
		
		String country[]={"A","B","C","D","E"};        
		JComboBox cb=new JComboBox(country);    
		cb.setBounds(10, 30,90,20);    
		this.add(cb);        
		
		mp = new MyPanel();
		this.add(mp);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Ball ball = new Ball(this.mp);
		System.out.println("button utworzyl nowy Ball");
	}
}
