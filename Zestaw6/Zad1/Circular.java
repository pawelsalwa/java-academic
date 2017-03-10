package Zad1;

import java.lang.reflect.Array;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Circular<E extends Serializable> implements Serializable, BlockingQueue<E> {
	
	int size;
	int head;
	int rear;
	E[] buf;
	
	public Circular(int size){
		this.size = size;
		this.rear= 0;
		this.head = 0;
		buf = (E[]) new Serializable[this.size];
	}
	
	/*Circular(Class<E> clazz, int size){

        @SuppressWarnings("unchecked")
        final E[] buf = (E[]) Array.newInstance(clazz, size);
        this.buf = buf;
        this.head = 0;
        this.rear = 0;
    }*/
	
	
	@Override
	public E element() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public synchronized E poll() {
		// TODO Auto-generated method stub
		if(this.buf[this.head - 1] != null) {
            E tmp = this.buf[this.head - 1];
            this.buf[this.head-1] = null;
            this.head = this.head-1;
            return tmp;
        }
		else{
        	return null;
        }
	}

	@Override
	public synchronized E remove() {
		// TODO Auto-generated method stub
		this.poll();
		return null;
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public Iterator<E> iterator(Circular obj) {
		// TODO Auto-generated method stub
		return new CircularIterator<E>(obj);
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		//Object[] wynikowa = Arrays.copyOf(this.buf, this.size);
		
		return (T[]) java.lang.reflect.Array.newInstance(arg0.getClass().getComponentType(), this.size);
	}

	@Override
	public synchronized boolean add(E arg0) {
		// TODO Auto-generated method stub
		return offer(arg0);
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int drainTo(Collection<? super E> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int drainTo(Collection<? super E> arg0, int arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public synchronized boolean offer(E arg0) {
		// TODO Auto-generated method stub
		//warunki kolejki z definicji(przod nie jest za tylem)
		if(((this.head == this.rear) && (this.buf[this.rear] != null)) || ((this.head == (this.size -1)) && this.rear == 0)){
			return false;
		}
		else{
			this.buf[head] = arg0;
			this.head = this.head + 1;
			this.head = this.head % this.buf.length;
            return true;
		}
	}

	@Override
	public boolean offer(E arg0, long arg1, TimeUnit arg2) throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E poll(long arg0, TimeUnit arg1) throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public synchronized void put(E arg0) throws InterruptedException {
		// TODO Auto-generated method stub
		while(((this.head == this.rear) && (this.buf[this.rear] != null)) || ((this.head == (this.size -1)) && this.rear == 0)){
			this.wait();
		}
		offer(arg0);
	}

	@Override
	public int remainingCapacity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		for(int i = 0; i < this.size; i++){
            if(buf[i] == arg0) {
                buf[i] = null; // zapobiec wyciekowi pamiêci
                return true;
            }
        }
		return false;
	}

	@Override
	public synchronized E take() throws InterruptedException {
		// TODO Auto-generated method stub
		E wynik;
		while( (wynik = poll()) == null){
			this.wait();
		}
		return wynik;
	}
	
	public void myString(){
		for(int i =0 ; i< size; i++){
			if(this.buf[i] == null){
				System.out.println(i+ ": Empty");
			}
			else{
				System.out.println(i+ ": odleglosc od heada: " + (this.size - i) + ", typ: " + this.buf[i].getClass() + ", napis: " + this.buf[i].toString());

			}
		}
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
