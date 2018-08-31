package com.algorithems;

import java.util.ArrayList;

import com.DS.graphUtils.Graph;
import com.DS.graphUtils.Vertics;

public class Main {

	public static void main(String[] arg) {
	
		example1();
		//example2();
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
		
		KruskalAlgo kAlgo = new KruskalAlgo(graph);
		ArrayList<Edge> mst = kAlgo.run();
		
		for (Edge edge: mst) {
			System.out.println("mst edges :  " + edge.dest.label + edge.src.label);
		}
		
	}
	
	static void example2() {
		Graph graph = new Graph();

		Vertics a = new Vertics(0, 'A', 0);
		Vertics b = new Vertics(1, 'B', 0);
		Vertics c = new Vertics(2, 'C', 0);
		Vertics d = new Vertics(3, 'D', 0);
		
		graph.addvertics(a);
		graph.addvertics(b);
		graph.addvertics(c);
		graph.addvertics(d);
		
		
		graph.addEdgesObject(new Edge(a, b, 2));
		graph.addEdgesObject(new Edge(b, c, 1));
		graph.addEdgesObject(new Edge(b, d, 5));
		graph.addEdgesObject(new Edge(c, d, 3));
		graph.addEdgesObject(new Edge(a, c, 2));
		graph.addEdgesObject(new Edge(a, a, 8));
		graph.addEdgesObject(new Edge(d, c, 12));
		graph.addEdgesObject(new Edge(d, d, 4));
		
		KruskalAlgo kAlgo = new KruskalAlgo(graph);
		ArrayList<Edge> mst = kAlgo.run();
		
		for (Edge edge: mst) {
			System.out.println("mst edges :  " + edge.dest.label + edge.src.label);
		}
	}

}
