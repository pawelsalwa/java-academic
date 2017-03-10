

public enum Kolor {
	
	
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
