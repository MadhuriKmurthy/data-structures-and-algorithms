package com.data.graph.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BellmanFordAlgorithm {
	
	// A class to represent a weighted edge in graph
    public static class Edge {
        int src;
        int dest;
        double distance;
        
		public Edge(int src, int dest, double distance) {
			this.src = src;
			this.dest = dest;
			this.distance = distance;
		}      
        
    };
    
	public static void main(String[] args) {

		System.out.println("**** BELLMAN - FORD ALGORITHM ****");
		System.out.println("Enter the number of vertices in the graph");
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		
		System.out.println("Enter the number of edges in the graph");
		int E = sc.nextInt();
		
		Edge[] edges = new Edge[E];
		System.out.println("Enter the source, destination and cost of each edge [edges start from 1]");
		for(int i = 0; i < E ; i++) {
			//source
			edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextDouble());
		}
		
		System.out.println("Enter the source from which the shortest path to all the vertices must be caluclated");
		int source = sc.nextInt();
		
		//Array that stores the shortest distance from source to all vertices
		double[] distance = new double[V + 1];
		//array to store the path
		int parent[] = new int[V];
		
		//1. Initialize all vertices to positive infinity, except source(0)
		for(int i = 0; i < V; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		Arrays.fill(parent, -1);
		//update source to 0
		distance[source] = 0;
		
		//Relax all edges (V-1) times!
		for(int i = 0; i < V - 1; i++) {//V - 1 part
			//each edge 
			for(int j = 0 ; j < E ; j++) {
				int u = edges[j].src; //source
				int v = edges[j].dest; //destination
				double dist = edges[j].distance; //weight/cost/price
				
				if(distance[u] != Integer.MAX_VALUE && //verify that source it self does not have infinity
						(distance[u] + dist) < distance[v]) { //LOGIC : check if sum of what you have at source vertex + the cost of the edge
							//is lesser than what's already present in destinations distance, if less, update,
							//if more do nothing.
					distance[v] = (distance[u] + dist);
							// set v's parent as `u`
                    		parent[v] = u;
				}	
			}
		}
		
		//print the distances
		for(int i = 0; i < V ; i++) {
			if(i != source) {
				List<Integer> path = new ArrayList<>();
	            getPath(parent, i, path);
				System.out.println("Distance from "+ source + " vertex to vertex " + i + " is "+ distance[i] + " with path " + path);		
			}
		}
		
	}
	// Recursive function to print the path of a given vertex from source vertex
    static void getPath(int parent[], int vertex, List<Integer> path)
    {
        if (vertex < 0) {
            return;
        }
 
        getPath(parent, parent[vertex], path);
        path.add(vertex);
    }

}
