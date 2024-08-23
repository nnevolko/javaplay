package main.java;

	/*
	 * nnevolko
	 */
import java.util.ArrayList;
import java.util.List;


public class HashTableN<K, V>{
	
	List<ArrayList<PairN>> hashTable;
	int largeSize = 10000;
	private int size;
	
	public HashTableN(){
		hashTable = new ArrayList<ArrayList<PairN>>();
		size =0;

	}
	
	public boolean insert(K key, V value){	
		int hashCode = key.hashCode();
		int index = hashCode % largeSize;
		PairN newValue = new PairN(key, value);
		if (hashTable.get(index)!= null && hashTable.get(index).size()>0){
			ArrayList<PairN> list = hashTable.get(index);
			if (!list.contains(newValue)){
				list.add(newValue);
				size++;
			}
		} else {
			ArrayList<PairN> list = new ArrayList<PairN>();
			list.add(newValue);
			hashTable.set(index, list);
			size++;
		}
		//check on double insertion, and null key elements
		return true;
	}
	
	
	public V get(K key){		
		int hashCode = key.hashCode();
		int index = hashCode % largeSize;
		
		if (hashTable.get(index) == null){
			return null;
		} else{
			if(hashTable.get(index).size()>0){
				//
			}
		}
		if (hashTable.get(index)!= null && hashTable.get(index).size()>0){
			ArrayList<PairN> list = hashTable.get(index);
			//
		} 
		return null;
	}
	
	public boolean remove (K key){
		
		return true;
	}
	
	public int size(){
		return size;
		
	}
	private static class PairN<K,V>{
		private K key;
	    private V value;

	    public PairN(K key, V value) {
	    	this.key = key;
	    	this.value = value;
	    }

	    public K getKey()	{ return key; }
	    public V getValue() { return value; }
	}


}
