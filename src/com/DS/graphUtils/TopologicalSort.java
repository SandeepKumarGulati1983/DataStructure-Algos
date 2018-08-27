package com.DS.graphUtils;

public class TopologicalSort {

	/*
	 * Can not be used for graph with cycles
	 * 
	 * A graph with no cycle is called a tree
	 * 
	 * TS Must be carried out on directional graph with no cycle. such a graph is
	 * called as acyclic directional graph.
	 * 
	 * if a graph with N node have more then N-1 edges then the graph is having the
	 * cycle.
	 */

	
public void run (Graph g ,Vertics startingPoint) {
	
	BFS bfs = new BFS(g);
	bfs.bfs(startingPoint);
}

}
