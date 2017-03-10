package zad2;

import java.util.Collection;
import java.util.Iterator;

public class BinarySearchTree<E extends Comparable<? super E>> implements Collection<E> {

	Node<E> root;
	static Integer[] array;
	
	
	public static void main(String[] args) {
		test();
	}
	
	static void test(){
		BinarySearchTree<OrderedPair<Integer, String>> list = new BinarySearchTree<OrderedPair<Integer, String>>();
		
		OrderedPair<Integer, String> op1 = new OrderedPair<Integer, String>(5, "piec");
		list.add(op1);
		OrderedPair<Integer, String> op2= new OrderedPair<Integer, String>(4, "cztery");
		list.add(op2);
		OrderedPair<Integer, String> op3= new OrderedPair<Integer, String>(3, "trzy");
		list.add(op3);
		OrderedPair<Integer, String> op4= new OrderedPair<Integer, String>(2, "dwa");
		list.add(op4);
		OrderedPair<Integer, String> op5 = new OrderedPair<Integer, String>(1, "raz");
		list.add(op5);
		
		BinaryIterator<OrderedPair<Integer, String>> bi = list.iterator();
		
		System.out.println("wyswietlam 'list' po kolei wartosciami");
		for(Object e : list) {
			System.out.println(bi.next());
		}
		
	}
	
	@Override
	public boolean add(E element) {
		// TODO Auto-generated method stub
		if(root == null) {
			root = new Node<E>(element);
		}
		else {
			add(element, root);
		}
		return true;
	}
	
	public boolean add(E element, Node<E> root) {
		// TODO Auto-generated method stub
		if(root.value.compareTo(element) > 0) { //jezeli element mniejszy od root.value to dodajemy go na lewa strone
			if(root.left == null)
				root.left = new Node<E>(element);
			else
				add(element, root.left);
		}
		
		else if(root.value.compareTo(element) < 0) {//tak samo dla wiekszego tylkoze na prawa strone
			if(root.right == null)
				root.right = new Node<E>(element);
			else
				add(element, root.right);
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("UnsupportedOperation");
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("UnsupportedOperation");
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("UnsupportedOperation");
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("UnsupportedOperation");
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("UnsupportedOperation");
	}

	@Override
	public BinaryIterator<E> iterator() {
		// TODO Auto-generated method stub
		return new BinaryIterator<E>(root);
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("UnsupportedOperation");
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("UnsupportedOperation");
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("UnsupportedOperation");
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("UnsupportedOperation");
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("UnsupportedOperation");
	}

	@Override
	public <T> T[] toArray(T[] tab) {
		inOrder(this.root, tab, 0);
		return tab;
	}
	
	public <T> int inOrder(Node<E> node, T[] tab , int i){
		if (node.left != null) {    //lewa strona
			i = inOrder(node.left, tab, i); //idziemy w lewo zawsze kiedy mozna
		}
		
		tab[i] = (T) ((OrderedPair<Integer, String>) node.value).getKey(); // jak jest po lewej to przypisujemy
		i++;   
		
		if (root.right != null) { //prawa strona
			i = inOrder(node.right, array, i); //idziemy w prawo dopiero, kiedy nie ma nic z lewej
		}
		
		
		return i; //index tablicy
	}
	
}
