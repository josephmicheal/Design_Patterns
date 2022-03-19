package com.tried.off;

public class CustomArrayListIteratorDesignPatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> list = new ArrayList<Integer>(5);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.remove(2);
		list.set(1, 111);
		list.print();
	}

}

class ArrayList<T> {
	T arr[];
	int tail = 0;
	float loadFactor = 2;

	public ArrayList(int size) {
		arr = (T[]) new Object[size];
	}

	public void add(T data) {
		if (isFull()) {
			T arrNew[] = (T[]) new Object[arr.length * 2];
			for (int i = 0; i < arr.length; i++) {
				arrNew[i] = arr[i];
			}
			arr = arrNew;
		}
		arr[tail++] = data;

	}

	public boolean isFull() {
		return arr.length == tail + 1;
	}

	public void remove(int index) {
		for (int i = index; i < arr.length - 1; i++) {
			arr[i] = arr[i + 1];
		}
		tail--;
		arr[arr.length - 1] = null;
	}

	public void set(int index, T data) {
		arr[index]=data;
	}

	public void print() {
		Iterator<T> iter = iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next()+ " ");
		}
	}
	
	public Iterator<T> iterator() {
		return new ListIterator();
	}
	
	class ListIterator implements Iterator{
		
		int pointer = 0;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return (pointer < tail);
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return arr[pointer++];
		}

		@Override
		public void reset() {
			// TODO Auto-generated method stub
			pointer=0;
		}
		
	}
}

interface Iterator<T>{
	public boolean hasNext();
	public T next();
	public void reset();
	
}
/*
Iterator is a behavioral design pattern that allows sequential traversal through 
a complex data structure without exposing its internal details.


All implementations of java.util.Iterator (also java.util.Scanner).

All implementations of java.util.Enumeration


*/