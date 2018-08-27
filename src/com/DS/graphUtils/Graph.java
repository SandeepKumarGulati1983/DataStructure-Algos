package com.DS.graphUtils;

import java.util.ArrayList;

public class Graph {

	ArrayList<Vertics> verticsList;
	int nVertics;
	int[][] adjecentMatrix ;
	
	Graph(){
		nVertics = 0;
		verticsList = new ArrayList<Vertics>();
		adjecentMatrix = new int[100][100];
	}
	
	void addvertics(Vertics v) {
		verticsList.add(v);
		v.index = nVertics;
		nVertics++;
	}
	
	void addEdge(int v1 , int v2) { // no weight over edge here 
		adjecentMatrix[v1][v2] = 1;
		//adjecentMatrix[v2][v1] = 1;  // if commented means directional graph 
	}
}
