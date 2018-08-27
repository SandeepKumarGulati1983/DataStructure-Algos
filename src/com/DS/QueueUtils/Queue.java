package com.DS.QueueUtils;

import java.util.ArrayList;

public class Queue {  // Do not use .. need to modify  the removal logic 

	// LIFO
	int rear, front; // item will come out from rear and insert from front
	int nElements;
	ArrayList<Object> array;

	public Queue() {
		rear = -1;
		front = 0;
		nElements = 0;
		array = new ArrayList<Object>();

	}

	public void insert(Object o) {
		array.add(o);
		front++;
		nElements++;
	}

	public Object remove() {

		Object o = array.remove(rear++);
		nElements--;

		return o;
	}

	public Object peek() {
		return array.get(front);
	}

	public boolean isEmpty() {

		return nElements >= 0 ? false : true;
	}

}
