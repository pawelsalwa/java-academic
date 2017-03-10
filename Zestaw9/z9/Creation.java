package z9;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import javax.swing.JFrame;
import java.lang.Class;

public class Creation {
	static Scanner odczyt;
	static String nazwaKlasy;
	static String arg1;
	
	public static void main(String args[]) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		odczyt = new Scanner(System.in);
		nazwaKlasy = odczyt.nextLine();
		arg1 = odczyt.nextLine();
		
		Class<?> cls = Class.forName(nazwaKlasy); //returns class object of nazwaKlasy
		Constructor<?> con = cls.getConstructor(); 
		Object obj = cls.newInstance();
		//Object obj = cls.newInstance(arg1); nie dziala, dlaczego?
		
	}
}
