package graph;

import java.util.Iterator;

public interface GraphADT<T> {
   /** Add a vertex to this graph, associating object with vertex. 
   * @throws Exception */
   public void addVertex (T vertex);

   /** Remove a single vertex with the given value from this graph. */
   public void removeVertex (T vertex);

   /** Insert an edge between two vertices of this graph. 
   * @throws Exception */
   public void addEdge (T vertex1, T vertex2);

   /** Remove an edge between two vertices of this graph. 
   * @throws Exception */
   public void removeEdge (T vertex1, T vertex2);

 	// does the graph contain this vertex
 	public boolean containsVertex(T vertex);
 	
	// does the graph contain this edge
	public boolean containsEdge(T fromVertex, T toVertex);

 	/** Return a breadth first iterator starting with the given vertex. */
  // public Iterator iteratorBFS(T startVertex);

   /** Return a depth first iterator starting with the given vertex. */
   //public Iterator iteratorDFS(T startVertex);

   /** Return an iterator for the shortest path between start and target */
   //public Iterator iteratorShortestPath(T startVertex, T targetVertex);

// iterate over vertexes from this vertex
 	public Iterator<T> verticesFrom(T fromVertex);
 	
   /** Return true if this graph is empty, false otherwise. */
   public boolean isEmpty();

   /** Return true if this graph is connected, false otherwise. */
   // public boolean isConnected();

   /** Return the number of vertices in this graph. */
   public int size();

   /** Return a string representation of the adjacency matrix. */
   public String toString();
}
