package com.DS.graphUtils.ShortestPath;

import com.DS.graphUtils.Graph;
import com.DS.graphUtils.Vertics;

public class SPMain {

	public static void main(String[] args) {

		GraphUtils graph = new GraphUtils();
		graph = prepareDijesktraGraph(graph);
		
		DijekstraAlgoSP dijekstraAlgo = new DijekstraAlgoSP(graph);
		dijekstraAlgo.runDijesktra();
	}

	static GraphUtils prepareDijesktraGraph(GraphUtils graph) {
		
		
		graph.addvertics(new Vertics(0, 'A', 100)); // 0
		graph.addvertics(new Vertics(1, 'B', 100)); // 1
		graph.addvertics(new Vertics(2, 'C', 100)); // 2
		graph.addvertics(new Vertics(3, 'D', 100));// 3
		graph.addvertics(new Vertics(4, 'E', 100)); // 4
		graph.addvertics(new Vertics(5, 'Z', 100));// 5
		
		graph.addEdge(0, 1, 4);
		graph.addEdge(1, 3, 5);
		graph.addEdge(3, 6, 6);
		graph.addEdge(0, 2, 2);
		graph.addEdge(1, 2, 1);
		graph.addEdge(2, 3, 8);
		graph.addEdge(2, 4, 10);
		graph.addEdge(3, 4, 2);
		graph.addEdge(4, 5, 3);
		
		return graph;
	}
	
}
