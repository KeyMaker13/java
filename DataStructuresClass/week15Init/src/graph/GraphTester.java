package graph;

import java.util.*;

import lib.LinkedQueue;
import lib.QueueADT;

public class GraphTester {
	public static void main(String[] args) {
		String[] cities1 = { "A", "CC", "D", "EP", "FW", "H", "SA" };
		String[][] cities2 = { { "SA", "H", "FW", "EP", "D" }, { "SA", "H" },
				{ "FW", "A" }, { "SA", "FW", "A" }, { "EP", "D", "A" },
				{ "SA", "CC", "A" }, { "H", "EP", "CC", "A" } };
		GraphADT<String> graph1 = new AdjacencyListGraph<String>();
		for (int i = 0; i < cities1.length; i++) {
			for (int j = 0; j < cities2[i].length; j++) {
				graph1.addEdge(cities1[i], cities2[i][j]);
			}
		}

		// print vertices from each city
		for (int i = 0; i < cities1.length; i++) {
			Iterator<String> iter = graph1.verticesFrom(cities1[i]);
			System.out.print("From " + cities1[i] + ", there are edges to:");
			while (iter.hasNext()) {
				System.out.print(" " + iter.next());
			}
			System.out.println();
		}

		// print breadth-first search from each city
		for (int i = 0; i < cities1.length; i++) {
			System.out.print("Breadth-first search from " + cities1[i] + ":");
			bfs(graph1, cities1[i]);
			System.out.println();
		}

		// print depth-first search from each city
		for (int i = 0; i < cities1.length; i++) {
			System.out.print("Depth-first search from " + cities1[i] + ":");
			dfs(graph1, cities1[i]);
			System.out.println();
		}

		// graph2 will correspond to parent-child relationships
		// in a binary heap
		GraphADT<Integer> graph2 = new AdjacencyListGraph<Integer>();
		for (int i = 9; i > 0; i--) {
			graph2.addVertex(i);
			graph2.addEdge((i - 1) / 2, i);
		}
		// print vertices from each index
		for (int i = 0; i < 10; i++) {

			Iterator<Integer> iter = graph2.verticesFrom(i);
			System.out.print("From " + i + ", there are edges to:");
			while (iter.hasNext()) {
				System.out.print(" " + iter.next());
			}
			System.out.println();

		}
		System.out.print("Breadth-first search of heap indexes:");
		bfs(graph2, 0);
		System.out.print("\nDepth-first search of heap indexes:");
		dfs(graph2, 0);
		System.out.println();
	}

	// print a breadth-first search from an element
	public static <T> void bfs(GraphADT<T> graph, T elt) {
		// create a set to remember vertices that have been visited
		Set<T> marked = new HashSet<T>();
		QueueADT<T> q = new LinkedQueue<T>();
		q.enqueue(elt);
		while (!q.isEmpty()) {
			T current = q.dequeue();
			if (!marked.contains(current)) {
				System.out.print(" " + current);
				marked.add(current);
				Iterator<T> iter = graph.verticesFrom(current);
				while (iter.hasNext()) {
					q.enqueue(iter.next());
				}
			}
		}
	}

	// print a depth-first search from an element
	public static <T> void dfs(GraphADT<T> graph, T elt) {
		// create a set to remember vertices that have been visited
		Set<T> marked = new HashSet<T>();
		// recursive version
		dfs(graph, elt, marked);
	}

	// recursive version
	public static <T> void dfs(GraphADT<T> graph, T elt, Set<T> marked) {
		if (!marked.contains(elt)) {
			System.out.print(" " + elt);
			marked.add(elt);
			Iterator<T> iter = graph.verticesFrom(elt);
			while (iter.hasNext()) {
				dfs(graph, iter.next(), marked);
			}
		}
	}

}
