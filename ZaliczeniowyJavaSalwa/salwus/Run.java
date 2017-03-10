package salwus;

public class Run {
	
	static boolean player;
	static MyFrame mf0;
	
	public static void main(String[] args) {
        
		player = Boolean.valueOf(args[0]);
		
        mf0 = new MyFrame(player);
        //MyFrame mf1 = new MyFrame(true);
         
    }
}
