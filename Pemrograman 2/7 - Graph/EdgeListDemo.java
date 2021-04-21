import java.util.ArrayList;

public class EdgeListDemo {
    public static void main(String[] args) {
        int numVertex = 6;

        EdgeListGraph graph = new EdgeListGraph(numVertex);

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

class EdgeListGraph {
    static class Edge {
        private int one, two;

        public Edge(int one, int two) {
            this.one = one;
            this.two = two;
        }

        public void displayEdge() {
            System.out.println("(" + this.one + "," + this.two + ")");
        }
    }

    private int numVertex;
    private ArrayList<Edge> edgeList;

    public EdgeListGraph(int numVertex) {
        this.numVertex = numVertex;
        this.edgeList = new ArrayList<Edge>();
    }

    public void addEdge(int one, int two) {
        this.edgeList.add(new Edge(one, two));
    }

    public void displayGraph() {
        for (int i=0 ; i<this.edgeList.size() ; i++) {
            this.edgeList.get(i).displayEdge();
        }
    }
}
