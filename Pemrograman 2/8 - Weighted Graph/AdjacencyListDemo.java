import java.util.ArrayList;

public class AdjacencyListDemo {
    public static void main(String[] args) {
        int numVertex = 6;

        AdjacencyListGraph graph = new AdjacencyListGraph(numVertex);

        graph.addEdge(1, 2, 6);
        graph.addEdge(1, 5, 7);
        graph.addEdge(2, 3, 4);
        graph.addEdge(2, 5, 5);
        graph.addEdge(3, 4, 9);
        graph.addEdge(4, 5, 6);
        graph.addEdge(4, 6, 8);

        graph.displayGraph();
    }
}

class AdjacencyListGraph {
    static class Neighbor {
        private int val, weight;

        public Neighbor(int val, int weight) {
            this.val = val;
            this.weight = weight;
        }

        public void displayNeighbor() {
            System.out.print("(" + this.val + "," + this.weight + ")");
        }
    }

    private int numVertex;
    private ArrayList<ArrayList<Neighbor>> adjacencyList;

    public AdjacencyListGraph(int numVertex) {
        this.numVertex = numVertex;
        this.adjacencyList = new ArrayList<ArrayList<Neighbor> >(numVertex+1);

        for (int i = 0; i <= numVertex; i++)
            this.adjacencyList.add(new ArrayList<Neighbor>());
    }

    public void addEdge(int one, int two, int weight) {
        this.adjacencyList.get(one).add(new Neighbor(two, weight));
        this.adjacencyList.get(two).add(new Neighbor(one, weight));
    }

    public void displayGraph() {
        for (int i=1 ; i<=this.numVertex ; i++) {
            System.out.print(i + " : ");
            ArrayList<Neighbor> neighbors = this.adjacencyList.get(i);
            for (int j=0 ; j<neighbors.size() ; j++) {
                neighbors.get(j).displayNeighbor();
                if (j<neighbors.size() - 1)
                    System.out.print(",");
                else
                    System.out.println();
            }
        }
    }
}
