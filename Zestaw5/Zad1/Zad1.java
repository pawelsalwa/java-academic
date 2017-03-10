package generics;

import java.awt.Color;

public class Zad1{
	public static void main(String[] args){
		
        Mieszadlo mieszadlo = Mieszadlo.ADD;
        
        for (Kolor a: Kolor.values()){
            for (Kolor b: Kolor.values()){
            	Kolor kolorab = mieszadlo.mieszaj(a,b);
                if (kolorab != null){
                    System.out.println(a + " + " + b + " = " + mieszadlo);
                }
            }
        }
    }
}

enum Kolor {
	
	
    BLACK (0,0,0),
    WHITE (1,1,1),
    GREY (0.5,0.5,0.5),  
    RED (1,0,0),
    GREEN (0,1,0),
    BLUE (0,0,1),
    YELLOW (1,1,0),
    CYAN (0,1,1),
    MAGENTA (1,0,1);

    public double r;
    public double g; 
    public double b;
    
    Kolor(double r, double g , double b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }
    
    public double red()   { return r; }
    public double green() { return g; }
    public double blue() { return b; }
    
    public boolean porownaj(double r, double g, double b){
    	if (this.r == r && this.g == g && this.b == b)
    		return true;
    	return false;
    }
    
    public static Kolor nazwij(double r, double g, double b){
    	for(Kolor a : Kolor.values()){
    		if (a.r == r && a.g == g && a.b == b)
    			return a;
    	}
    	return null;
    }
}

enum Mieszadlo {

    ADD{
        public Kolor mieszaj(Kolor a, Kolor b){
            return Kolor.nazwij(a.r + b.r, a.g + b.g, a.b + b.b);
        }
    },
    
    MUL{
        public Kolor mieszaj(Kolor a, Kolor b){
            return Kolor.nazwij(a.r * b.r, a.g * b.g, a.b * b.b);
        }
    },

    AVERAGE{
        public Kolor mieszaj(Kolor a, Kolor b){
            return Kolor.nazwij((a.r + b.r)/2, (a.g + b.g)/2, (a.b + b.b)/2);
        }
    };
	
	public abstract Kolor mieszaj(Kolor a, Kolor b);
	
}