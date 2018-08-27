package com.DS.graphUtils;

public class Vertics {
	public char label;
	public int weight;
	public boolean wasVisited;
	public int index;

	public  Vertics(int index, char label, int weight) {
		this.label = label;
		this.weight = weight;
		this.wasVisited = false;
		this.index = index;
	}
}
