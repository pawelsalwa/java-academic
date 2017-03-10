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

public class Ball extends Thread implements MouseListener{
	
	int x=0;
	int y=0;
	int vx=2;
	int vy=2;
	MyPanel mp;
	boolean czyDziala;
	
	public Ball(MyPanel mp){
		this.mp = mp;
		
		System.out.println("utworzono nowy 'Ball'");
		this.start();
		
		
	}
	public synchronized void run(){
		
		this.czyDziala = true;
		Graphics g = this.mp.getGraphics();
		
		this.mp.addMouseListener(this);
		
		while(true){
			g.setColor(this.mp.getBackground());
			g.fillOval(this.x, this.y, 40, 40);
			
			if( x<0 || x>this.mp.getWidth()-40)
				vx = -vx;
			if( y<0 || y>this.mp.getHeight()-40)
				vy = -vy;
			this.x+=vx;
			this.y+=vy;
			
			g.setColor(Color.BLACK);
			g.fillOval(this.x, this.y, 40, 40);
			
			try{
				this.sleep(20);
			}
			catch (InterruptedException e){
				System.out.println("cos sie wali");
			}
			Entered();
			
		}		
	}
	
	boolean Entered(){
		if( (this.x > this.mp.recx || this.x < this.mp.recx + 100) && (this.x > this.mp.recy || this.x < this.mp.recy + 100)){
			return true;
		}
		return false;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getX() < this.x + 20 || e.getY() < this.y + 20) {
			if (this.czyDziala){
				this.czyDziala = false;
				this.suspend();
			}
			else{
				this.resume();
				this.czyDziala = true;
			}
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
