import java.util.ArrayList;

public class EdgeListDemo {
    public static void main(String[] args) {
        int numVertex = 6;

        EdgeListGraph graph = new EdgeListGraph(numVertex);

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

class EdgeListGraph {
    static class Edge {
        private int one, two, weight;

        public Edge(int one, int two, int weight) {
            this.one = one;
            this.two = two;
            this.weight = weight;
        }

        public void displayEdge() {
            System.out.println("(" + this.one + "," + this.two + "," + this.weight + ")");
        }
    }

    private int numVertex;
    private ArrayList<Edge> edgeList;

    public EdgeListGraph(int numVertex) {
        this.numVertex = numVertex;
        this.edgeList = new ArrayList<Edge>();
    }

    public void addEdge(int one, int two, int weight) {
        this.edgeList.add(new Edge(one, two, weight));
    }

    public void displayGraph() {
        for (int i=0 ; i<this.edgeList.size() ; i++) {
            this.edgeList.get(i).displayEdge();
        }
    }
}
