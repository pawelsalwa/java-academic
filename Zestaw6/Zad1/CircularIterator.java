package Zad1;

import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class CircularIterator<E extends Serializable> implements Iterable, Iterator<E>{

    int i; //index buf
    Circular obj;
    
    
	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}


    public CircularIterator(Circular obj){
        i = 0;
        this.obj = obj;
    }

    @Override
    public boolean hasNext(){
        this.i %= obj.size; //z def kolejki, kiedy konczy sie miejsce w tablicy dzielimy modulo
        return obj.buf[this.i] != null;
    }

    @Override
    public E next(){
        this.i %= obj.size; //z def kolejki, kiedy konczy sie miejsce w tablicy dzielimy modulo
        this.i++;
        return (E) obj.buf[this.i];
    }

    @Override
    public void remove() {
        throw new ConcurrentModificationException();
    }
}