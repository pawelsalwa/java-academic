package mandelbrot;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

public class Mandelbrot extends JComponent implements RegionChooser{
	private int WIDTH;
	private int HEIGHT; 
	private int ITERATIONS;
	private int SCALE;
	
	public BufferedImage bImage;
	//================================================================================	
	public Mandelbrot(int WIDTH, int HEIGHT, int ITERATIONS, int SCALE){
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
		this.ITERATIONS = ITERATIONS;
		this.SCALE = SCALE;
		
		bImage = new BufferedImage(WIDTH , HEIGHT, BufferedImage.TYPE_INT_RGB);	
		render();
	}
	//================================================================================	
//	@Override
	//public void paint(Graphics g){
	//	g.drawImage(bImage , 0 ,0 ,null);
	//}
	//================================================================================
	public void render(){
		for(int x=0;x<WIDTH;x++){
			for(int y=0;y<HEIGHT;y++){
				int color = calculatePoint((x-WIDTH/2.0f)/SCALE , (y-HEIGHT/2f)/SCALE);
				bImage.setRGB(x, y, color);
			}
		}
	}
	//================================================================================
	private int calculatePoint(float x, float y) {
		
		float cx = x;
		float cy = y;
		
		int i=0;
		
		for(;i<ITERATIONS;i++){
			float nx = x*x - y*y + cx;
			float ny = 2*x*y + cy;
			x = nx;
			y = ny;
			
			if(x*x + y*y > 4) break;
			//if(new Complex((double)x,(double)y).sqrAbs() < 2) break;
		}
		if(i == ITERATIONS) return 0;
		return Color.HSBtoRGB(( (float)i/ITERATIONS + 0.001f) , 2f , -1 );
		
		// TODO Auto-generated method stub
	}
	//================================================================================
	public void RegionChoosen(){
		return;
	}
}
