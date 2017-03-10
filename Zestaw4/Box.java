package watki;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.lang.Thread;

import javax.swing.JPanel;
import javax.swing.Timer;

import javax.swing.JPanel;

public class Box extends Thread {
	public int x = 50;
	public int y = 20;
	public int width = 50;
	public int height = 50;
	
	JPanel mp;
	
	public Box(JPanel mp){
		this.mp = mp;
		System.out.println("utworzono nowy 'Box'");
		this.start();
		
		
	}
	
	public synchronized void run(){
		Graphics g = mp.getGraphics();
		g.setColor(Color.BLACK);
		g.fillOval(x, y, width, height);
		//g.drawRect(50, 50, this.width, this.height);
	}
}
