package com.algorithems;

public class FordFulkursonAlgo {

	/*
	 * --- Jone and Eva ----------------- Bipartite Matching.
	 *
	 * One of the oldest problems in combinatorial algorithms is that of deter-
	 * mining the size of the largest matching in a bipartite graph G. (As a special
	 * case, note that G has a perfect matching if and orfly if IXl -- IVl and it
	 * has a matching of size IXI.) This problem turns out to be solvable by an
	 * algorithm that runs in polynomial time, but the development of this algorithm
	 * needs ideas fundamentally different from the techniques that we’ve seen so
	 * far
	 * 
	 * network flow problems--that includes the Bipartite Matching Problem as a
	 * special case.
	 * 
	 * We then develop a polynomial-time algorithm for a general problem, the
	 * Maxim~m-FIotv Problem, and show how this provides an efficient algorithm for
	 * Bipartite Matching as well
	 * 
	 * One often uses graphs to model transportation networks--networks whose edges
	 * carry some sort of traffic and whose nodes act as "switches" passing traffic
	 * between different edge
	 * 
	 * 
	 * BEST REFERENCES ==================================================
	 * https://web.stanford.edu/class/cs97si/08-network-flow-problems.pdf
	 * 
	 * * Understanding Set theory -------------------
	 * https://www.geeksforgeeks.org/set-theory/
	 * 
	 * A ⊆ B ‘ denotes A is a subset of B. Size of the set S is known as Cardinality
	 * number, denoted as |S|. Power set is the set all possible subset of the set
	 * S. Denoted by P(S). Cardinality of power set is 2^n Cartesian product of A
	 * and B is denoted by A × B,
	 * 
	 * 
	 * https://www.geeksforgeeks.org/max-flow-problem-introduction/
	 * The idea of residual graph is used The Ford-Fulkerson and Dinic’s algorithms
	 * 
	 * BEST ----------
	 * https://web.stanford.edu/class/cs97si/08-network-flow-problems.pdf
	 * Theorem: (maximum flow) = (minimum cut)
	 * 
	 */

	
	/*
	 * IMPLEMENTATION =========
	 * 
	 * consider capacity as weight as of now 
	 * 
	 * flow conditions : -
	 * 1. Flow on edge e doesn’t exceed c(e)
	 * 2. Except source or target / sink (v != s, t) incoming flow is equal to outgoing flow
	 * 
	 * 
	 * 
	 */
	
}
