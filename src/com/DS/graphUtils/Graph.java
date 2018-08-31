package com.DS.graphUtils;

import java.util.ArrayList;
import java.util.Comparator;

import com.algorithems.Edge;

public class Graph {

	public ArrayList<Vertics> verticsList;
	public int nVertics;
	public int[][] adjecentMatrix;
	public ArrayList<Edge> edgeArray;

	Edge edge; // for priority queue

	public Graph() {
		nVertics = 0;
		verticsList = new ArrayList<Vertics>();
		adjecentMatrix = new int[100][100];
		edgeArray = new ArrayList<Edge>();
	}

	public void addvertics(Vertics v) {
		verticsList.add(v);
		v.index = nVertics;
		nVertics++;
	}

	public void addEdge(int v1, int v2) { // no weight over edge here
		adjecentMatrix[v1][v2] = 1;
		// adjecentMatrix[v2][v1] = 1; // if commented means directional graph
	}

	public void addEdgesObject(Edge e) {
		this.edge = e; // for priority queue
		edgeArray.add(e);
	}

}
