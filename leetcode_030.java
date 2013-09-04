/*
Implement heap (priority queue).
*/

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Heap<T extends Comparable<T> {
	private ArrayList<T> items;
	
	public Heap() {
		items = new ArrayList<T>();
	}
	
	public int size() {
		return items.size();
	}
	
	public boolean isEmpty() {
		return items.isEmpty();
	}
	
	public String toString() {
		return items.toString();
	}

	public void siftUp() {
		int k = items.size()-1;
		while(k > 0) {
			int p = (k-1)/2;
			T item = items.get(k);
			T parent = items.get(p);
			if(item.compareTo(parent) > 0) {
				items.set(k, parent);
				items.set(p, item);
				k = p;
			} else {
				break;
			}
		}
	}
	
	public void siftDown() {
		int k = 0;
		int l = 2*k+1;
		while(l < items.size()) {
			int max = l, r = l+1;
			if(r < items.size()) {
				if(items.get(r).compareTo(items.get(l)) > 0)	max++;
			}
			if(items.get(k).compareTo(items.get(max)) < 0) {
				int temp = items.get(k);
				items.set(k, items.get(max));
				items.set(max, temp);
				k = max;
				l = 2*k + 1;
			} else {
				break;
			}
		}
	}
	
	public void insert(T t) {
		items.add(t);
		siftUp();
	}
	
	public T delete() 
	throws NoSuchElementException {
		if(items.size() == 0)	throw new NoSuchElementException();
		if(items.size() == 1)	return items.remove(0);
		T saveLater = items.get(0);
		items.set(0,items.remove(items.size()-1));
		siftDown();
		return saveLater;
	}
}
