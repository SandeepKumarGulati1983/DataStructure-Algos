package com.algorithems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import com.DS.graphUtils.Graph;
import com.DS.graphUtils.Vertics;

public class KruskalAlgo {

	/*
	 * -------as per Jone and Eva ----------------------- Suppose , we want that in a
	 * particular graph when ever a new edge will be added in between a pair of
	 * vertices then instead of re-computing the distance from the start , we
	 * develop a Union-find kind of data structure , which will store the
	 * representation of the component in a way ,so that the SEARCH and UPDATE will
	 * be very fast
	 * 
	 * 1. Need an edge Class - which will store start , destination and weight for
	 * each edge e = (startV, destinationV) .
	 * 
	 * We need to find the identities of the connected component containing v and w
	 * 
	 * if the components exist that means edge is already exist else we need to add
	 * it.
	 * 
	 * Union-Find data structure allow us to maintain disjoint set.
	 * 
	 * we need to create a function 1. find(v) which will return all the sets
	 * containing v .
	 * 
	 * similarly for another vertices u , find(u). if find (v) = find (u) thats
	 * means u and v are in the same set
	 * 
	 * 2. Union (u, v) for merge them in to a single set
	 * 
	 * 3. makeUnionFindSet(S) will return a union-find data structure - s is a Union
	 * set
	 * 
	 * Existing material ------------------------------
	 * https://www.geeksforgeeks.org/kruskals-minimum-spanning-tree-algorithm-greedy
	 * -algo-2/ https://www.geeksforgeeks.org/union-find/
	 * 
	 * Step 1 : sort the edges as by cost. ===================
	 * 
	 * Step 2 :- pick the minimum cost edges and check weather it cause a cycle or
	 * not . if cycle discard else keep. ===================
	 * 
	 * A disjoint-set data structure is a data structure that keeps track of a set
	 * of elements, partitioned into a number of disjoint (non-overlapping) subsets.
	 * 
	 * A union-find algorithm is an algorithm that performs two useful operations on
	 * such a data structure:
	 * 
	 * Find: Determine which subset a particular element is in. This can be used for
	 * determining if two elements are in the same subset.
	 * 
	 * Union: Join two subsets into a single subset.
	 * 
	 * Step3:-do this till v-1 iterations. =================
	 * 
	 * 
	 * IMPROVMENT AREAS =========== finding MST is not Kruskal prime intension ,
	 * prime intension is fast update and search in a forest of tree
	 * 
	 * So Needed tree and forest concept also . in bookish language , need multiple
	 * disjoint set and there array
	 * 
	 * Forest = [Set0, Set1, ------, Sn ] or [tree0, Tree1 , Tree3 ---- Tree N ]
	 * https://www.geeksforgeeks.org/count-number-trees-forest/
	 * 
	 */

	Graph graph;
	ArrayList<Edge> edgeArrayList;
	ArrayList<Edge> mstArrayList;
	ArrayList<Vertics> vArrayList;
	PriorityQueue<Edge> sortedEdgesQueue;

	public KruskalAlgo(Graph g) {
		this.graph = g;
		init();
	}

	private void init() {
		edgeArrayList = graph.edgeArray;
		mstArrayList = new ArrayList<Edge>();
		vArrayList = graph.verticsList;
	}

	public ArrayList<Edge> run() {

		// step1 - sort edges ==============
		sortedEdgesQueue = sortEdges(edgeArrayList);

		while (mstArrayList.size() < vArrayList.size() && sortedEdgesQueue.size() > 0) {
			Edge edge = sortedEdgesQueue.remove();
			// step2 - run union-find() ====
			// to check that edge is making a cycle or not
			mstArrayList.add(edge);
			if (isCycle(mstArrayList)) {
				// do nothing
				mstArrayList.remove(edge);
			} else {

			}
		} // Step 3 - repete till (e = v-1) =
		return mstArrayList;
	}

	public boolean isCycle(ArrayList<Edge> mstList) {
		// Allocate memory for creating V subsets

		int[] parent = new int[this.graph.nVertics];

		// Initialize all subsets as single element sets
		for (int i = 0; i < this.graph.nVertics; ++i)
			parent[i] = -1;

		// Iterate through all edges of graph, find subset of both
		// vertices of every edge, if both subsets are same, then
		// there is cycle in graph.

		for (int i = 0; i < mstList.size(); ++i) {
			int x = find(parent, mstList.get(i).dest.index);
			int y = find(parent, mstList.get(i).src.index);

			if (x == y)
				return true;

			Union(parent, x, y);
		}
		return false;

	}

	// A utility function to find the subset of an element i
	int find(int parent[], int i) {
		if (parent[i] == -1)
			return i;
		return find(parent, parent[i]);
	}

	// A utility function to do union of two subsets
	void Union(int parent[], int x, int y) {
		int xset = find(parent, x);
		int yset = find(parent, y);
		parent[xset] = yset;
	}

	public PriorityQueue<Edge> sortEdges(ArrayList<Edge> edges) {
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
		for (Edge e : edges) {
			queue.add(e);
		}

		return queue;

	}

	/*
	 * https://www.geeksforgeeks.org/kruskals-minimum-spanning-tree-algorithm-greedy
	 * -algo-2/
	 */

	// A class to represent a subset for union-find
	class subset {
		int parent, rank;
	};

	int find(subset subsets[], int i) {
		// find root and make root as parent of i (path compression)
		if (subsets[i].parent != i)
			subsets[i].parent = find(subsets, subsets[i].parent);

		return subsets[i].parent;
	}

	void Union(subset subsets[], int x, int y) {
		int xroot = find(subsets, x);
		int yroot = find(subsets, y);

		// Attach smaller rank tree under root of high rank tree
		// (Union by Rank)
		if (subsets[xroot].rank < subsets[yroot].rank)
			subsets[xroot].parent = yroot;
		else if (subsets[xroot].rank > subsets[yroot].rank)
			subsets[yroot].parent = xroot;

		// If ranks are same, then make one as root and increment
		// its rank by one
		else {
			subsets[yroot].parent = xroot;
			subsets[xroot].rank++;
		}
	}

}
