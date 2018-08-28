package com.DS.Tree;

public class Node {

	public int data;
	public char label;
	public Node leftChild, rightChild;

	public Node(char label, int data) {
		this.data = data;
		this.label = label;
		this.leftChild = this.rightChild = null;

	}

}
