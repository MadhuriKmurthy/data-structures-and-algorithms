package com.data.graph.basics;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class BFSGraphTraversal {

	public static void main(String[] args) {

		AdjacencyListOfGraph.adjacencyListMain();
		List<List<Integer>> adjList = AdjacencyListOfGraph.adjList;		

		//Queue to keep track of which node to visit next
		Queue<Integer> myQueue = new LinkedList<>();
		//Data structure to keep track of visited nodes..List? Set? Just a array should be fine
		Set<Integer> visited = new HashSet<>();
		//output array
		int[] bfsOutput = new int[adjList.size()];
		int addHere = 0;
		
		
		System.out.println("Enter the node from which you want to start the BFS");
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		
		//add the starting node to the queue
		myQueue.add(start);
		//until all the nodes are visited.
		while(visited.size() != adjList.size()) {
			int currentNode = myQueue.poll();
			List<Integer> adjacentNodes = adjList.get(currentNode);
			if(adjacentNodes == null) {
				System.out.println("The node does not exist in the graph");
				break;
			}
			//add the node to the answer
			//add to the output only if it is not visited
			if (!visited.contains(currentNode)) {
				bfsOutput[addHere] = currentNode;
				addHere++;
				System.out.println("Adding to visited " + currentNode);
				visited.add(currentNode);
			}
			//add its adjacent nodes to output array
			for (int i = 0; i < adjacentNodes.size(); i++) {
				// add to the output only if it is not visited
				System.out.println("Adding to frontier " + adjacentNodes.get(i));
				myQueue.add(adjacentNodes.get(i));
				if (!visited.contains(adjacentNodes.get(i))) {
					bfsOutput[addHere] = adjacentNodes.get(i);
					addHere++;
					System.out.println("Adding to visited " + adjacentNodes.get(i));
					visited.add(adjacentNodes.get(i));
				}

			}
			
		}
		
		System.out.append("BFS : ");
		for(int ele: bfsOutput) {
			System.out.print(ele+ ", ");
		}
	}

}
