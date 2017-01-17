package graph;
import java.util.*;
import lib.SimpleLinkedList;
public class AdjacencyListGraph<T> implements GraphADT<T> {
	// This should map from a vertex to a list of vertices
	private Map<T,SimpleLinkedList<T>> adjacencyList;
	private int size;
	
	public AdjacencyListGraph() {
		adjacencyList = new HashMap<T, SimpleLinkedList<T>>();
		size = 0;

	}
	
	// add a vertex to the graph
	public void addVertex(T vertex) {
		if (!containsVertex(vertex)){
			adjacencyList.put(vertex, new SimpleLinkedList<T>());
		}
	}
	
	// add a vertex to the graph
	public boolean containsVertex(T vertex) {
		return adjacencyList.containsKey(vertex);
	}
	
	// add an edge to the graph
	public void addEdge(T fromVertex, T toVertex) {
		if(!containsEdge(fromVertex,toVertex)){
			if(!containsVertex(fromVertex)){
				addVertex(fromVertex);
				addVertex(toVertex);
				adjacencyList.get(fromVertex).add(toVertex);
				// adjacencyList.get(toVertex).add(fromVertex); // needed for undirected graph
				
			}
		}
		
	}
	
	// does the graph contain this edge
	public boolean containsEdge(T fromV, T toV) {
		return	containsVertex(fromV) && containsVertex(toV) && adjacencyList.get(fromV).contains(toV); // && adjacencyList.get(toV).contains(fromV); //needed for undirected graph
	}
	
	// iterate over vertexes from this vertex
	public Iterator<T> verticesFrom(T fromVertex) {
		return adjacencyList.get(fromVertex).iterator();
	}
	
	// returns the number of edges in the graph
	public int size() { return size; }


	public boolean isEmpty() {
	
		return false;
	}

	
	public void removeEdge(T vertex1, T vertex2) {
		if(!containsEdge(vertex1,vertex2)){
			System.out.println("Edge is not in the graph");
		}
		adjacencyList.get(vertex1).remove(vertex2);
		
	}

	
	public void removeVertex(T vertex) {
		if(!containsVertex(vertex)){
			System.out.println("Not here buddy");
		}
			adjacencyList.remove(vertex);
	}
}
