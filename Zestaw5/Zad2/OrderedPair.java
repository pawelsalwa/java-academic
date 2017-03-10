package zad2;

public class OrderedPair<K extends Comparable<? super K>, V> implements Comparable <OrderedPair<K,V>>  , Pair<K,V>{
	
	K key;
	V value;
	
	OrderedPair(K k, V v) {
		this.key = k;
		this.value = v;
	}
	@Override
	public int compareTo(OrderedPair<K, V> op) {
		// TODO Auto-generated method stub
		return this.key.compareTo(op.key);
	}

	@Override
	public K getKey() {
		// TODO Auto-generated method stub
		return this.key;
	}

	@Override
	public V getValue() {
		// TODO Auto-generated method stub
		return this.value;
	}
	
	public String toString() {
		if (key.getClass().getSimpleName() == "Integer")
			return Integer.toString((int) key);
		else if (key.getClass().getSimpleName() == "String")
			return (String) key;
		return null;
	}

}
