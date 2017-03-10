package Zad1;

import java.io.*;
import java.util.Iterator;

public class RunZad1 {
	
    public static void main(String[] args) {
        String[] tmp = new String[]{"pierwszy","drugi","trzeci","czwarty"};
        
        Circular<String> circular = new Circular<>(4);
        
        for (int i = 0; i < tmp.length; i++) {
            try {
                circular.put(tmp[i]);
            } catch (InterruptedException e) {
            }
            if (i != 0){
                circular.rear++;
            }
            circular.rear %= circular.size; //z definicji kolejki- dzieli sie modulo przez size, bo jest ograniczona ilosc miejsca
        }
        
//===========================serializacja================================================
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        
        try {
        	   fos= new FileOutputStream("test.ser"); //utworzenie strumienia wyjsciowego
        	   oos = new ObjectOutputStream(fos);  //utworzenie obiektu zapisuj¹cego do strumienia
        	   
        	   oos.writeObject(circular); //serializacja obiektu
        	   
        } catch (FileNotFoundException e) {
        	e.printStackTrace();
        } catch (IOException e) {
        	   e.printStackTrace();
        } finally {
        	// zamykamy strumienie w finally
        	try {
        		if (oos != null) oos.close();
        	} catch (IOException e) {}
        	try {
        		if (fos != null) fos.close();
        	} catch (IOException e) {}
        }
        
//===========================deserializacja================================================

        Circular circular2 = null;
        /*
         * Odczyt ze strumienia plikowego (ale moze byc dowolne)
         */
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
        	fis = new FileInputStream("test.ser"); //utworzenie strumienia wejsciowego  
        	ois = new ObjectInputStream(fis); //utworzenie obiektu odczytuj¹cego obiekty ze strumienia
          
        	circular2 = (Circular) ois.readObject(); //deserializacja obiektu
        
        } catch (FileNotFoundException e) {
        	e.printStackTrace();
        } catch (IOException e) {
        	e.printStackTrace();
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
        } finally {
        	// zasoby zwalniamy w finally
        	try {
        	if (ois != null) ois.close();
        	} catch (IOException e) {}
        	try {
        		if (fis != null) fis.close();
        	} catch (IOException e) {}
        }
        
        System.out.println("faktyczne sprawdzanie obiektu po deserializacji (myString):");

        circular2.myString();
        
//==========iterator===========================================================================
        
        Circular<String> circular3 = new Circular<String>(16);
        
        //Iterator iterator = circular3.iterator();        
        // Dodaæ elementy do bufora
        circular3.offer("asd");
        circular3.offer("qwe");
        circular3.offer("zxc");
        //tu jest jakis problem - moze z implementacja iteratora?
       /* for(String s : circular3){
        	System.out.println(s);
        }*/
        
    }
}