package com.data.graph.basics;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AdjacencyListOfGraphW {

	public static List<List<Node>> adjList = new ArrayList<>();

	// Node of the adjacency list can have a value and its cost to reach the node.
	// will be helpful for Dijkstra's Algorithm.
	public static class Node {
		int value;
		int cost;

		public Node(int value, int cost) {
			this.value = value;
			this.cost = cost;
		}
	}

	// Edge class for directed weighted graph from one node to another.
	public static class Edge {
		int souce;
		int destination;
		int weight;

		public Edge(int souce, int destination, int weight) {
			this.souce = souce;
			this.destination = destination;
			this.weight = weight;
		}

	}

	public static void main(String[] args) {
		
		adjacencyListMainWithWeight();
	}
	
	public static void adjacencyListMainWithWeight() {
		System.out.println("**** Graph representation using adjacency " + "list for directed weighted graph ****");

		System.out.println("Enter the vertices in the graph");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();


		// initialize adjacency lists for all the vertices
		for (int i = 1; i <= n + 1; i++) {
			adjList.add(new ArrayList<Node>());
		}

		System.out.println("Enter source, destination and weight");
		while (true) {
			try {
				addEdge(adjList, new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
			} catch (InputMismatchException ime) {
				break;
			}

		}

		System.out.println("Print the weighted graph");
		for (int i = 1; i < adjList.size(); i++) {
			List<Node> nodeList = adjList.get(i);
			for (int j = 0; j < nodeList.size(); j++) {
				System.out.println(i + " -> " + nodeList.get(j).value + " cost " + nodeList.get(j).cost);
			}
			System.out.println();
		}
		sc.close();
	}

	private static void addEdge(List<List<Node>> adjList, Edge e) {
		adjList.get(e.souce).add(new Node(e.destination, e.weight));
	}

}
