package com.DS.graphUtils;

import java.util.LinkedList;
import java.util.Queue;

//import com.DS.QueueUtils.Queue;  // mine 

public class BFS {

	Graph graph;
	//Queue queue; // mine 
	
	Queue<Vertics> queue; // java collection queue

	BFS(Graph g) {
		this.graph = g;
		queue = new LinkedList<Vertics>();
		//queue = new Queue(); //mine 
	}

	public void run() {

		Vertics startingVertics = graph.verticsList.get(0);
		bfs(startingVertics);

	}
	
	public void bfs(Vertics v) {
		v.wasVisited = true;
		queue.add(v);
		
		while (!queue.isEmpty()) {
			Vertics v1 = (Vertics) queue.remove();
			System.out.println("removed from queue " + v1.label);
			int index;
			while ((index = getAdjacent(v1)) >= 0) {
				queue.add(graph.verticsList.get(index));
				System.out.println("added to queue " + graph.verticsList.get(index).label);
			}

		}
	}

	private int getAdjacent(Vertics v) {

		for (int i = 0; i < graph.verticsList.size(); i++) {
			if (graph.adjecentMatrix[v.index][i] > 0 && graph.verticsList.get(i).wasVisited == false) {
				graph.verticsList.get(i).wasVisited = true;
				return i;
			}
		}
		return -1;
	}

}
