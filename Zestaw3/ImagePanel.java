package mandelbrot;


import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;  
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagePanel extends JPanel implements java.awt.event.ActionListener, MouseMotionListener , MouseListener {
	
	int xStart;
	int yStart;
	int xEnd;
	int yEnd;
	JFrame jFrame;
	JLabel statusbar = new JLabel("mouse not dragged on the area yet");
	JLabel statusbar2 = new JLabel("button tu wypisze dane");
	
	BufferedImage bImage;

	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	JButton but1 = new JButton("setTXT");
//================================================================================
	public static void main(String[] args) throws IOException {
		ImagePanel ip = new ImagePanel();
		
    }
//================================================================================
	public ImagePanel(){		
		jFrame = new JFrame("moja");
		
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
		jFrame.setSize(400,400);
		jFrame.setLayout(new GridLayout(2,1));
		
		this.setBackground(Color.GREEN);
		this.setSize(100, 100);
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		
		but1.addActionListener(this);
		
		jp1.setLayout(new GridLayout(3,1));
		jp1.add(statusbar);
		jp1.add(but1);
		jp1.add(statusbar2);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(15,15,15,15);
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=5;
		gbc.gridheight=1;
		jFrame.add(jp1,gbc);

		gbc.gridx=0;
		gbc.gridy=1;
		gbc.gridwidth=30;
		gbc.gridheight=30;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		
		jFrame.add(this);
		repaint();
	}
//================================================================================

//================================================================================   

 	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
        statusbar.setText("Mouse Dragged: ("+e.getX()+", "+e.getY() +")");
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
        statusbar.setText("Mouse Moved: ("+e.getX()+", "+e.getY() +")");
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
        statusbar.setText("Mouse Clicked: ("+e.getX()+", "+e.getY() +")");
		
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
		statusbar.setText("Mouse Pressed: ("+e.getX()+", "+e.getY() +")");
		this.xStart = e.getX();
		this.yStart = e.getY();
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		statusbar.setText("Mouse Released: ("+e.getX()+", "+e.getY() +")");
		this.xEnd = e.getX();
		this.yEnd = e.getY();
		
		int width = xEnd - xStart;
		if(width<0) width = -width;
		int height = yEnd - yStart;
		if(height<0) height = -height;
		this.setBackground(Color.GRAY);
		statusbar2.setBackground(Color.RED);

		
		Mandelbrot man = new Mandelbrot(width,height,100,width/4);
		bImage = man.bImage;
		repaint();
	}
	
	@Override
	public void paint(Graphics g){
		g.drawImage(bImage , xStart ,yStart ,null);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		statusbar2.setText("xStart: " + xStart + ",    yStart:     " + yStart + "   |===|   xEnd: " + xEnd + ",    yEnd: " + yEnd);
	}
}