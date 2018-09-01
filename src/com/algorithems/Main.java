package com.algorithems;

import java.util.ArrayList;

import com.DS.graphUtils.DFS;
import com.DS.graphUtils.Graph;
import com.DS.graphUtils.Vertics;

public class Main {

	public static void main(String[] arg) {

		//example1();
		// example2();
		fordFukersonGraph();
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

		for (Edge edge : mst) {
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

		for (Edge edge : mst) {
			System.out.println("mst edges :  " + edge.dest.label + edge.src.label);
		}
	}

	static void fordFukersonGraph() {
		Graph graph = new Graph();

		Vertics s = new Vertics(0, 'S', 0);
		Vertics a = new Vertics(1, 'A', 0);
		Vertics b = new Vertics(2, 'B', 0);
		Vertics c = new Vertics(3, 'C', 0);
		Vertics d = new Vertics(4, 'D', 0);
		Vertics t = new Vertics(5, 'T', 0);

		graph.addvertics(a);
		graph.addvertics(b);
		graph.addvertics(c);
		graph.addvertics(d);
		graph.addvertics(s);
		graph.addvertics(t);

		// graph is directed 
		graph.addEdgeWithWeight(s.index, a.index, 16);
		graph.addEdgeWithWeight(s.index, c.index, 13);
		graph.addEdgeWithWeight(c.index, a.index, 4);
		graph.addEdgeWithWeight(a.index, c.index, 10);
		graph.addEdgeWithWeight(a.index, b.index, 12);
		graph.addEdgeWithWeight(b.index, c.index, 9);
		graph.addEdgeWithWeight(b.index, t.index, 20);
		graph.addEdgeWithWeight(c.index, d.index, 14);
		graph.addEdgeWithWeight(d.index, b.index, 7);
		graph.addEdgeWithWeight(d.index, t.index, 4);
		
		DFS dfs = new DFS(graph);
		dfs.run();

	}

}
