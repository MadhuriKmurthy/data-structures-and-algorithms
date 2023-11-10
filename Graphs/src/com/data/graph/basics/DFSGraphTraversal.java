package com.data.graph.basics;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class DFSGraphTraversal {

	public static void main(String[] args) {
		AdjacencyListOfGraph.adjacencyListMain();
		List<List<Integer>> adjList = AdjacencyListOfGraph.adjList;		

		//Queue to keep track of which node to visit next
		Stack<Integer> myStack = new Stack<>();
		//Data structure to keep track of visited nodes..List? Set? Just a array should be fine
		Set<Integer> visited = new HashSet<>();
		//output array
		int[] dfsOutput = new int[adjList.size()];
		int addHere = 0;
		
		System.out.println("Enter the node from which you want to start the DFS");
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		
		
		//add the first element into the stack and output array
		myStack.add(start);

		
		while(!myStack.isEmpty()) {
			int currentNode = myStack.pop();
			//see adjacency list for the popped one.
			List<Integer> adjacencyList = adjList.get(currentNode);
			if(adjacencyList == null) {
				System.out.println("Node is not present in the graph");
				break;
			}			
			
			//this was visited
			visited.add(currentNode);
			//add to output array
			dfsOutput[addHere] = currentNode;
			addHere++;
			
			for(int i = 0; i < adjacencyList.size(); i++) {
				if(!visited.contains(adjacencyList.get(i))) {
					myStack.push(adjacencyList.get(i));
				}
			}
			
		}
		
		
		System.out.append("DFS : ");
		for(int ele: dfsOutput) {
			System.out.print(ele+ ", ");
		}
		
		
	}
	

}
