package com.DS.graphUtils;

public class GraphutilsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph graph = setUpGraph(new Graph());

		DFS dfs = new DFS(graph);
		dfs.run();

		// BFS bfs = new BFS(graph);
		// bfs.run();

		/*
		 * MST is working as DFS - only printing the visited edges so the Answer should
		 * be Minimum spanning tree: AB BC CD DE
		 */
		// Graph graph = setupMSTGraph(new Graph());
		// MST mst = new MST(graph);
		// mst.run();

		/*
		 * before running topological search first make edge direction in Graph . 
		 */
		// Graph g = setupTopologicalSearchGraph(new Graph());
		// TopologicalSort ts = new TopologicalSort(); // worked as directional BFS
		// //ts.run(g, g.verticsList.get(0));
		// //ts.run(g, g.verticsList.get(1));
		// ts.run(g, g.verticsList.get(2));
	}

	public static Graph setUpGraph(Graph graph) {
		graph = new Graph();
		graph.addvertics(new Vertics(0, 'A', 0)); // 0
		graph.addvertics(new Vertics(1, 'B', 0)); // 1
		graph.addvertics(new Vertics(2, 'C', 0)); // 2
		graph.addvertics(new Vertics(3, 'D', 0));// 3
		graph.addvertics(new Vertics(4, 'E', 0)); // 4
		graph.addvertics(new Vertics(5, 'F', 0));// 5
		graph.addvertics(new Vertics(6, 'G', 0));// 6
		graph.addvertics(new Vertics(7, 'H', 0));// 7
		graph.addvertics(new Vertics(8, 'I', 0));// 8
		graph.addvertics(new Vertics(9, 'J', 0));// 9
		graph.addvertics(new Vertics(10, 'K', 0));// 10
		graph.addvertics(new Vertics(11, 'L', 0));// 11

		// A--> B--> F--> I --> K
		graph.addEdge(0, 1);
		graph.addEdge(1, 5);
		graph.addEdge(5, 8);
		graph.addEdge(8, 10);

		// A--> B--> F--> I --> L
		graph.addEdge(8, 11);

		// A --> C --> G
		graph.addEdge(0, 2);
		graph.addEdge(2, 6);

		// A --> D
		graph.addEdge(0, 3);

		// A--> E --> H -- J
		graph.addEdge(0, 4);
		graph.addEdge(4, 7);
		graph.addEdge(7, 9);
		return graph;

		// Q - without index -- i will not be able to run for loop in BFS DFS algo over
		// vertics
	}

	public static Graph setupMSTGraph(Graph graph) {
		graph = new Graph();
		graph.addvertics(new Vertics(0, 'A', 0)); // 0
		graph.addvertics(new Vertics(1, 'B', 0)); // 1
		graph.addvertics(new Vertics(2, 'C', 0)); // 2
		graph.addvertics(new Vertics(3, 'D', 0));// 3
		graph.addvertics(new Vertics(4, 'E', 0)); // 4

		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);

		// AB // AC // AD // AE // BC // BD // BE // CD // CE // DE

		return graph;
	}

	public static Graph setupTopologicalSearchGraph(Graph graph) {
		// ---page -- 650
		graph.addvertics(new Vertics(0, 'A', 0)); // 0
		graph.addvertics(new Vertics(1, 'B', 0)); // 1
		graph.addvertics(new Vertics(2, 'C', 0)); // 2
		graph.addvertics(new Vertics(3, 'D', 0));// 3
		graph.addvertics(new Vertics(4, 'E', 0)); // 4
		graph.addvertics(new Vertics(5, 'F', 0));// 5
		graph.addvertics(new Vertics(6, 'G', 0));// 6
		graph.addvertics(new Vertics(7, 'H', 0));// 7

		graph.addEdge(0, 3);// AD
		graph.addEdge(0, 4);// AE
		graph.addEdge(3, 6);// DG
		graph.addEdge(4, 6);// EG
		graph.addEdge(6, 7);// GH
		graph.addEdge(1, 4);// BE
		graph.addEdge(2, 5);// CF
		graph.addEdge(5, 7);// FH

		return graph;
	}

}
