package zad2;

import java.util.Iterator;
import java.util.Stack;

public class BinaryIterator<E extends Comparable<? super E>> implements Iterator<E> {
	
	Stack<Node<E>> stack; //stos przechowuje elementy po kolei
	 
	public BinaryIterator(Node<E> node) {
		stack = new Stack<Node<E>>();
		
		stworzLewe(node);
	}
 
	public E next() {
		// TODO Auto-generated method stub
		Node<E> node = stack.pop();
		E value = node.value; //ze szczytu stosu bierze najmniejszy elemtn
		
		
		if (node.right != null) {
			node = node.right;
			stworzLewe(node);  //nowy right jest sprawdzany pod katem lewych odnog drzewa
		}
		
		
		return value;
	}
	
	void stworzLewe(Node<E> node){ //tworzy lewe odnogi drzewa 
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return !stack.isEmpty();
	}

}
