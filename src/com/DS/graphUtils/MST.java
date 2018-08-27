package com.DS.graphUtils;

import com.DS.StackUtils.Stack;

public class MST {

	/*
	 * --P643-- Suppose that you’ve designed a printed circuit board , and you want
	 * to be sure you’ve used the minimum number of traces. That is, you don’t want
	 * any extra connections between pins; such extra connections would take up
	 * extra room and make other circuits more difficult to lay out. It would be
	 * nice to have an algorithm that, for any connected set of pins and traces
	 * (vertices and edges, in graph terminology), would remove any extra traces.
	 * The result would be a graph with the minimum number of edges necessary to
	 * connect the vertices.
	 * 
	 * formula to verify a minimum spanning tree is E = V-1 always
	 * 
	 * this is not shortest path , its only minimum edges required
	 * 
	 */

	Graph graph;
	Stack stack;
	int edge;
	MST(Graph graph) {
		this.graph = graph;
		stack = new Stack();
		edge = 0;
	}

	public void run() {
		StringBuffer sb = new StringBuffer(); // for printing answer as ""Minimum spanning tree: AB BC CD DE "
		
		Vertics v = graph.verticsList.get(0);
		v.wasVisited = true;
		stack.push(v);
		while (!stack.isEmpty()) {
			int index = getAdjacentVertics(v);
			if (index >= 0) {
				Vertics previousV = v;
				v = graph.verticsList.get(index);
				v.wasVisited = true;
				stack.push(v);
				edge++;
				sb.append(String.valueOf(previousV.label) +String.valueOf( v.label) +" " );
			} else {
				v = (Vertics) stack.pop();
			}
		}
		
		System.out.println("Minimum spanning tree: "+ sb.toString());
		
//		DFS dfs = new DFS(graph);
//		dfs.run();

	}

	public int getAdjacentVertics(Vertics v) {

		for (int i = 0; i < graph.nVertics; i++) {
			if (graph.adjecentMatrix[v.index][i] == 1 && graph.verticsList.get(i).wasVisited == false) {
				return graph.verticsList.get(i).index;
			}
		}
		return -1;
	}
	
	public boolean isCircularGraph() {
		return graph.nVertics-1 == edge ? false : true ;
	}

}
