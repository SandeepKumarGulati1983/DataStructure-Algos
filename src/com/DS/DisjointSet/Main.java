package com.DS.DisjointSet;

import java.util.ArrayList;

import com.DS.graphUtils.Graph;
import com.DS.graphUtils.Vertics;
import com.algorithems.Edge;
import com.algorithems.KruskalAlgo;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph graph  = example2();
		
		DisjointSet disjointSet  = new DisjointSet();
		disjointSet.createDisjointsets(graph.verticsList);
		disjointSet.runUnion_find(graph.edgeArray);
		disjointSet.displayDisjointSet();
		
		
		
	}
	
	static void example1() {
		Graph graph = new Graph();

		Vertics a = new Vertics(0, 'A', 0);
		Vertics b = new Vertics(1, 'B', 0);
		Vertics c = new Vertics(2, 'C', 0);
		Vertics d = new Vertics(3, 'D', 0);
		Vertics e = new Vertics(4, 'E', 0);
		Vertics f = new Vertics(5, 'F', 0);
		Vertics g = new Vertics(6, 'G', 0);

		graph.addvertics(a);
		graph.addvertics(b);
		graph.addvertics(c);
		graph.addvertics(d);
		graph.addvertics(e);
		graph.addvertics(f);
		graph.addvertics(g);

		graph.addEdgesObject(new Edge(a, b, 7));
		graph.addEdgesObject(new Edge(b, c, 8));
		graph.addEdgesObject(new Edge(a, d, 5));
		graph.addEdgesObject(new Edge(b, e, 7));
		graph.addEdgesObject(new Edge(b, d, 9));
		graph.addEdgesObject(new Edge(d, e, 15));
		graph.addEdgesObject(new Edge(d, f, 6));
		graph.addEdgesObject(new Edge(f, e, 8));
		graph.addEdgesObject(new Edge(f, g, 11));
		graph.addEdgesObject(new Edge(e, g, 9));
		graph.addEdgesObject(new Edge(e, c, 5));


	}
	
	static Graph example2() { // corman - page 563
		
		Graph graph = new Graph();
		Vertics a = new Vertics(0, 'A', 0);
		Vertics b = new Vertics(1, 'B', 0);
		Vertics c = new Vertics(2, 'C', 0);
		Vertics d = new Vertics(3, 'D', 0);
		Vertics e = new Vertics(4, 'E', 0);
		Vertics f = new Vertics(5, 'F', 0);
		Vertics g = new Vertics(6, 'G', 0);
		Vertics h = new Vertics(6, 'H', 0);
		Vertics i = new Vertics(6, 'I', 0);
		Vertics j = new Vertics(6, 'J', 0);
		

		graph.addvertics(a);
		graph.addvertics(b);
		graph.addvertics(c);
		graph.addvertics(d);
		graph.addvertics(e);
		graph.addvertics(f);
		graph.addvertics(g);
		graph.addvertics(h);
		graph.addvertics(i);
		graph.addvertics(j);
		
		graph.addEdgesObject(new Edge(a, b, 1));
		graph.addEdgesObject(new Edge(a, c, 1));
		graph.addEdgesObject(new Edge(c, b, 1));
		graph.addEdgesObject(new Edge(b, d, 1));
		graph.addEdgesObject(new Edge(e, f, 1));
		graph.addEdgesObject(new Edge(e, g, 1));
		graph.addEdgesObject(new Edge(h, i, 1));
		
		return graph;
	}

}
