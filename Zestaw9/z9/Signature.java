package z9;

import java.text.DateFormat.Field;
import java.util.Scanner;
import java.lang.reflect.*;


public class Signature {
	static Scanner odczyt;
	static String nazwaKlasy;
	public static void main(String args[]) throws ClassNotFoundException{
		
		 odczyt = new Scanner(System.in);
		 nazwaKlasy = odczyt.nextLine();
		 
		 Class c = Class.forName(nazwaKlasy);
		 System.out.println("==========wpisales klase: " + c.getName() + "============");
		//=======members of the class represented by this Class object.==============================================
		 Class[] cls = c.getClasses();
		 System.out.println("Klasy reprezentowane przez obiekt tej klsay:" + c.toString() + ":");
		 for( int i =0; i < cls.length ; i++){
			 System.out.println(i+ cls[i].toString());
		 }
		//=======================interfejsy==============================================
		 Class[] interf = c.getInterfaces();
		 System.out.println("konstruktory klasy " + c.toString() + ":");
		 for( int i =0; i < interf.length ; i++){
			 System.out.println(i+ interf[i].toString());
		 }
		//=======================konstruktory==============================================
		 java.lang.reflect.Constructor[] cons = c.getConstructors();
		 System.out.println("konstruktory klasy " + c.toString() + ":");
		 for( int i =0; i < cons.length ; i++){
			 System.out.println(i+ cons[i].toString());
		 }
		//=======================metody==============================================
		 Method[] mets = c.getDeclaredMethods();
		 System.out.println("konstruktory klasy " + c.toString() + ":");
		 for( int i =0; i < mets.length ; i++){
			 System.out.println(i+ mets[i].toString());
		 }
		//=======================pola==============================================
		 java.lang.reflect.Field[] fields = c.getDeclaredFields();
		 System.out.println("pola klasy " + c.toString() + ":");
		 for( int i =0; i < fields.length ; i++){
			 System.out.println(i+ fields[i].toString());
		 }
		//=======================modyfikatory==============================================
		 int mods = c.getModifiers();
		 System.out.println("modyfikatory klasy zakodowane w (INT): " + mods);
		 
	}
}
