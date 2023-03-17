package assign07;

import java.util.LinkedList;
import java.util.Iterator;

/**
 * This class represents a vertex (AKA node) in a directed graph. The vertex is
 * not generic, assumes that a string name is stored there.
 *
 * @author Erin Parker
 * @version March 3, 2022
 */
public class Vertex<T> {

	// used to id the Vertex
	private T name;
	private boolean visited = false;
	private Vertex<T> cameFrom;

	private int inCount = 0;

	// adjacency list
	private LinkedList<Edge<T>> adj;

	/**
	 * Creates a new Vertex object, using the given name.
	 *
	 * @param name - string used to identify this Vertex
	 */
	public Vertex(T name) {
		this.name = name;
		this.adj = new LinkedList<Edge<T>>();
		this.cameFrom = null;

	}

	public void cameFrom(Vertex<T> n) {
		this.cameFrom = n;
	}

	public Vertex<T> getCameFrom() {
		return this.cameFrom;
	}

	/**
	 * @return the string used to identify this Vertex
	 */
	public String getName() {
		return name.toString();
	}

	/**
	 * Adds a directed edge from this Vertex to another.
	 *
	 * @param otherVertex - the Vertex object that is the destination of the edge
	 */
	public void addEdge(Vertex<T> otherVertex) {
		adj.add(new Edge<T>(otherVertex));
	}

	/**
	 * @return a iterator for accessing the edges for which this Vertex is the
	 *         source
	 */
	public Iterator<Edge<T>> edges() {
		return adj.iterator();
	}

	/**
	 * Generates and returns a textual representation of this Vertex.
	 */
	public String toString() {
		String s = "Vertex " + name + " adjacent to vertices ";
		Iterator<Edge<T>> itr = adj.iterator();
		while (itr.hasNext())
			s += itr.next() + "  ";
		return s;
	}

	public void isVisited(boolean T) {
		this.visited = T;
	}

	public boolean getVisited() {
		return visited;
	}

	public T getData() {
		return name;
	}

	public LinkedList<Edge<T>> getEdges(){
		return this.adj;
	}

	public void removeEdge(Edge<T> e) {
		for (int i = 0; i < adj.size(); i++) {
			if(e.equals(adj.get(i))){
				adj.remove(e);
			}
		}
	}
	public int edgeSize(){
		return adj.size();
	}

	public void changeInCount(int i){
		this.inCount = this.inCount+i;
	}
	public int getInCount(){
		return this.inCount;
	}
}
