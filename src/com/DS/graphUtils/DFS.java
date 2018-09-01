package com.DS.graphUtils;

import com.DS.StackUtils.Stack;

public class DFS {

	Graph graph;
	Stack stack; // FIFO

	public DFS(Graph graph) {
		this.graph = graph;
		stack = new Stack();
	}

	public void run() {

		Vertics startingVertics = graph.verticsList.get(0);
		dfs(startingVertics);
		
	}
	
	public void dfs(Vertics v) {
		v.wasVisited = true;
		stack.push(v);

		while (!stack.isEmpty()) {

			int index = getAdjacentVertics((Vertics) stack.peek());
			if (index >= 0) {
				v = graph.verticsList.get(index);
				stack.push(v);
				System.out.println("Adjacent vertics is : " + v.label);
			} else {
				System.out.println("poped  vertics is : " + ((Vertics) stack.pop()).label);
			}

		}
		System.out.println("----- END ---------");

	}

	int getAdjacentVertics(Vertics v) {
		Vertics v1;
		for (int i = 0; i < graph.nVertics; i++) {

			v1 = graph.verticsList.get(i);
			if (graph.adjecentMatrix[v.index][v1.index] > 0 && v1.wasVisited == false) {
				v1.wasVisited = true;

				return v1.index;
			}

		}

		return -1;

	}

}
