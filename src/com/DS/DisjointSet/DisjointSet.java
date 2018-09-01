package com.DS.DisjointSet;

import java.util.ArrayList;

import com.DS.graphUtils.Vertics;
import com.algorithems.Edge;

public class DisjointSet {

	/*
	 * Corman - Chapter 21 - p582 ============
	 * 
	 * Disjoint-set do two activity
	 * 
	 * 1. finding the uniqe set 2. uniting two set
	 * 
	 * --> disjoint-set data structure maintain the collection of S = {S1, S2, ---
	 * Sn} dynamic sets
	 * 
	 * --> identifies each set with a representative. in some application its does
	 * not matter which member will be the representative .Some application choose
	 * the smallest member in the set assuming that the the set is sorted.
	 * 
	 * --> make-set(x) create set and take care that x should not be in any other
	 * set.
	 * 
	 * --> Union(x,y) - Unite the sets containing x and y
	 * 
	 * --> Find-Set(x) - provide the pointer of the representative of the set
	 * containing x
	 * 
	 * -->Since the sets are disjoint, each UNION operation reduces the number of
	 * sets by one. After n 1 UNION operations, therefore, only one set remains. The
	 * number of UNION operations is thus at most n 1.
	 * 
	 * Application example ========== 1. determining the connected components of an
	 * undirected graph
	 * 
	 * implementation via linked list Page 563 -- is most important for
	 * understanding
	 * 
	 * 1. create a set of each vertices in a graph 2. for each edge find (srcV) and
	 * find (destV) if not belong to same set then make union(u, v) 3. else return
	 * true (which means cycle also in some case )
	 * 
	 */
	class Node {
		Vertics v; // data
		Node nextNode;

		Node(Vertics v, Node nextadd) {
			this.v = v;
			this.nextNode = nextadd;
		}
	}

	ArrayList<Node> disjointSetArray = new ArrayList<Node>();

	public void createDisjointsets(ArrayList<Vertics> verticsList) {
		for (Vertics v : verticsList) {
			Node n = new Node(v, null);
			disjointSetArray.add(n);
		}
		// displayDisjointSet();

	}

	public void runUnion_find(ArrayList<Edge> edgesarray) {

		for (Edge e : edgesarray) {
			union_find(e);
		}

	}

	public boolean union_find(Edge e) {

		Node x = find(e.src);
		Node y = find(e.dest);

		if (x == y) {
			return true;
		} else {
			union(x, y);
			return false;
		}

	}

	private Node find(Vertics v) {

		for (Node n : disjointSetArray) {
			Node temp = n;
			while (temp != null) {
				if (temp.v.index == v.index) {
					return n;
				} else {
					temp = temp.nextNode;
				}
			}
		}
		System.out.println("returning null ======");
		return null; // this will never happen if all vertices are entered in disjointsetArray
	}

	private void union(Node x, Node y) {

		disjointSetArray.remove(x);
		disjointSetArray.remove(y);

		Node temp = x.nextNode;
		Node parent = x;
		while (temp != null) {
			parent = temp;
			temp = temp.nextNode;
		}
		parent.nextNode = y;
		disjointSetArray.add(x);
		// displayDisjointSet();

	}

	public void displayDisjointSet() {
		int i = 1;
		System.out.println("there are total of :" + disjointSetArray.size() + " tree in this forest ");
		for (Node n : disjointSetArray) {
			Node temp = n;
			System.out.println("Node : " + n.v.label);
			while (temp.nextNode != null) {
				temp = temp.nextNode;
				System.out.println("Node : " + temp.v.label);
			}
			System.out.println("========Tree" + i++ + " ================");
		}

	}

}
