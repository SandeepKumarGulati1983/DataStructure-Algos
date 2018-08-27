package com.DS.graphUtils.ShortestPath;

import java.util.ArrayList;

import com.DS.graphUtils.Vertics;



public class GraphUtils {

	ArrayList<Vertics> verticsList;
	int nVertics;
	int[][] adjecentMatrix ;
	
	GraphUtils(){
		nVertics = 0;
		verticsList = new ArrayList<Vertics>();
		adjecentMatrix = new int[100][100];
	}
	
	void addvertics(Vertics v) {
		verticsList.add(v);
		v.index = nVertics;
		nVertics++;
	}
	
	void addEdge(int v1 , int v2, int edgeWeight) {
		adjecentMatrix[v1][v2] = edgeWeight;
		adjecentMatrix[v2][v1] = edgeWeight;  // if commented means directional graph 
	}
	
}
