package com.algorithems;

import com.DS.graphUtils.Vertics;

public class Edge implements Comparable<Edge> {

	public Vertics src;
	public Vertics dest;
	public int weight;

	public Edge(Vertics src, Vertics dest, int weight) {
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}

	@Override // for priority Queue
	public int compareTo(Edge e) {
		return this.weight - e.weight;
	}

}
