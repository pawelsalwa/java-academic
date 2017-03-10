
public class Paleta {
	
	public native void printText(Kolor c);
	
	static
	{
	  System.loadLibrary("Paleta");
	}

	public static void main(String[] args) {
		Paleta picasso  = new Paleta();
		picasso.printText(Kolor.BLUE);
    }
	
}


