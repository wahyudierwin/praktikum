public class AdjacencyMatrixDemo {
	public static void main(String[] args) {
		int numVertex = 6;

		AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(numVertex);

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

class AdjacencyMatrixGraph {
	private int numVertex;
	private int[][] AdjacencyMatrix;

	public AdjacencyMatrixGraph(int numVertex) {
		this.numVertex = numVertex;
		AdjacencyMatrix = new int[numVertex+1][numVertex+1];
	}

	public void addEdge(int one, int two) {
		this.AdjacencyMatrix[one][two] = 1;
		this.AdjacencyMatrix[two][one] = 1;
	}

	public void displayGraph() {
		for (int i=1 ; i<=this.numVertex ; i++) {
			for (int j=1 ; j<=this.numVertex ; j++) {
				System.out.print(this.AdjacencyMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}