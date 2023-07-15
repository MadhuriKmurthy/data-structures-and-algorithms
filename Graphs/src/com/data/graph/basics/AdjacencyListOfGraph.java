package com.data.graph.basics;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Instead of representing a graph as an adjacency matrix which is sequential in
 * nature, we can also use linked representation. This linked representation is
 * known as the adjacency list. An adjacency list is nothing but a linked list
 * and each node in the list represents a vertex.
 * 
 * The presence of an edge between two vertices is denoted by a pointer from the
 * first vertex to the second. This adjacency list is maintained for each vertex
 * in the graph.
 * 
 * When we have traversed all the adjacent nodes for a particular node, we store
 * NULL in the next pointer field of the last node of the adjacency list.
 * 
 * @author Madhuri
 *
 */
public class AdjacencyListOfGraph {


	// ArrayList which contains an arraylist. You could also have a linked list!
	static List<List<Integer>> adjList = new ArrayList<>();
	
	// Adjacency list of non-weighted graph.
	public static void main(String[] args) {
		adjacencyListMain();
	}

	public static void adjacencyListMain() {
		System.out
				.println("**** Graph representation using adjacency " + "list for undirected non-weighted graph ****");


		System.out.println("Enter the total number of nodes in the graph");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<Integer>());
		}

		System.out.println("Enter the nodes in the graph followed by the node to which it is connected(edge)");
		while (true) {
			try {
				addEdge(adjList, sc.nextInt(), sc.nextInt());
			} catch (InputMismatchException ime) {
				break;
			}
		}

		System.out.println("Printing the grapgh");
		for (int i = 0; i < adjList.size(); i++) {
			System.out.println("\nAdjacency list of vertex " + i);
			System.out.print("head");
			for (int j = 0; j < adjList.get(i).size(); j++) {
				System.out.print(" -> " + adjList.get(i).get(j));
			}
			System.out.println();
		}
		sc.close();
	}

	private static void addEdge(List<List<Integer>> adjList, int u, int v) {
		// add a link/edge between two vertices(u and v).
		adjList.get(u).add(v);
		//adjList.get(v).add(u);
	}

}
