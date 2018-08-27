package com.DS.graphUtils.ShortestPath;

import java.util.LinkedList;
import java.util.Queue;

import com.DS.graphUtils.Vertics;

/*
 * https://en.wikipedia.org/wiki/Shortest_path_problem
 * 
 * Dijkstra's algorithm solves the single-source shortest path problem with non-negative edge weight.
Bellman–Ford algorithm solves the single-source problem if edge weights may be negative.
A* search algorithm solves for single pair shortest path using heuristics to try to speed up the search.
Floyd–Warshall algorithm solves all pairs shortest paths.
Johnson's algorithm solves all pairs shortest paths, and may be faster than Floyd–Warshall on sparse graphs.
Viterbi algorithm solves the shortest stochastic path problem with an additional probabilistic weight on each node.
 * 
 */

public class DijekstraAlgoSP {

	GraphUtils graph;
	Queue<Vertics> pQueue; // to-do it should be priority queue.

	DijekstraAlgoSP(GraphUtils g) {
		this.graph = g;
		pQueue = new LinkedList<Vertics>();
	}

	public void runDijesktra() {
		Vertics v = graph.verticsList.get(0);
		/*
		 * step 1 - assign a weight 0 to first vertix and rest are infinity (very high )
		 */

		v.weight = 0;
		v.wasVisited = true;

		System.out.println("started from vertex : " + v.label + v.weight);

		for (int i = 0; i < graph.nVertics; i++) {
			int nearVertics = -1;
			/*
			 * step 2 - find all nearest vertics of first vertics
			 */
			while ((nearVertics = nextVertics(v.index)) != -1) {

				Vertics nearV = graph.verticsList.get(nearVertics);
				nearV.wasVisited = true; // this to stop next vertics search
				pQueue.add(nearV);
			}
			if (pQueue.size() > 0) {
				/*
				 * step 3 - from the nearest one choose the vertics with low weight .
				 */
				v = lightestVertics(pQueue);
				v.wasVisited = true; // so that we will not visit low cost vertics again .
			}

		} // Step 4 - repeat step 2 and 3 with other vertics.

	}

	private int nextVertics(int verticsIndex) {

		for (int i = 0; i < graph.nVertics; i++) {
			int edgeWeight = graph.adjecentMatrix[verticsIndex][i];

			if (edgeWeight > 0 && graph.verticsList.get(i).wasVisited == false) {

				int verticsWeight = graph.verticsList.get(i).weight;
				if (edgeWeight < verticsWeight) {
					// weight of a node is node weight + edge weight .
					graph.verticsList.get(i).weight = graph.verticsList.get(verticsIndex).weight + edgeWeight;
				}
				return i;
			}

		}
		return -1;
	}

	private Vertics lightestVertics(Queue<Vertics> queue) {
		Vertics refrence = queue.poll();
		refrence.wasVisited = false;
		Vertics compare;
		while (true) {
			if (queue.isEmpty()) {
				break;
			} else {
				compare = queue.poll();
				compare.wasVisited = false;
				if (compare.weight < refrence.weight) {
					refrence = compare;
				}
			}

		}
		System.out.println("returning  lightestVertics   : " + refrence.label + refrence.weight);
		return refrence;

	}

}
