package zad2;

public class Node<E extends Comparable<? super E>>{
	E value;
	Node<E> left;
	Node<E> right;
	
	Node(E element) {
		this.value = element;
	}
}
