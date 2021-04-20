import java.util.ArrayList;

public class AdjacencyListDemo {
	public static void main(String[] args) {
		int numVertex = 6;

		AdjacencyListGraph graph = new AdjacencyListGraph(numVertex);

		graph.addEdge(1, 2);
		graph.addEdge(1, 5);
		graph.addEdge(2, 3);
		graph.addEdge(2, 5);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(4, 6);

		graph.displayGraph();

	}
}

class AdjacencyListGraph {
	private int numVertex;
	private ArrayList<ArrayList<Integer>> adjacencyList;

	public AdjacencyListGraph(int numVertex) {
		this.numVertex = numVertex;
		this.adjacencyList = new ArrayList<ArrayList<Integer> >(numVertex+1);

		for (int i = 0; i <= numVertex; i++)
            this.adjacencyList.add(new ArrayList<Integer>());
	}

	public void addEdge(int one, int two) {
		this.adjacencyList.get(one).add(two);
		this.adjacencyList.get(two).add(one);
	}

	public void displayGraph() {
		for (int i=1 ; i<=this.numVertex ; i++) {
			System.out.print(i + " : ");
			ArrayList<Integer> neighbor = this.adjacencyList.get(i);
			for (int j=0 ; j<neighbor.size() ; j++) {
				System.out.print(neighbor.get(j) + " ");
			}
			System.out.println();
		}
	}
}