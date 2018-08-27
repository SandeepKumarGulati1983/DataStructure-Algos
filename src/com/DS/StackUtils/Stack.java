package com.DS.StackUtils;


import java.util.ArrayList;
import java.util.Arrays;

public class Stack {

	private int nElements;
	private ArrayList<Object> array;
	
	public Stack() {
		nElements = -1 ;
		array = new ArrayList<Object>();
	}
	
	public void push(Object o) {
		array.add(o);
		++nElements;
	}
	
	public Object pop() {
		
		return array.remove(nElements--);
	}
	
	public boolean isEmpty() {
		return nElements >=0 ?false : true;
	}
	
	public Object peek() {
		return array.get(nElements);
	}
	
}
