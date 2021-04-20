import java.util.ArrayList;

class Vertex {
	private int value;

	public Vertex(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	public void displayVertex() {
		System.out.println(this.value);
	}
}

class Edge {
    private Vertex one, two;
    private int weight;

    public Edge(Vertex one, Vertex two) {
        this(one, two, 1);
    }

    public Edge(Vertex one, Vertex two, int weight) {
        this.one = one;
        this.two = two;
        this.weight = weight;
    }

    public void displayEdge() {
    	System.out.println(this.one.getValue() + " " + this.two.getValue() + " : " + this.weight);
    }
}

class SimpleGraph {
    private ArrayList<Vertex> vertices;
    private ArrayList<Edge> edges;

    public SimpleGraph() {
        this.vertices = new ArrayList<Vertex>();
        this.edges = new ArrayList<Edge>();
    }

    public void addVertex(Vertex v) {
        this.vertices.add(v);
    }

    public void addEdge(Edge e) {
        this.edges.add(e);
    }

    public void displayGraph() {
        for (int i=0 ; i<this.vertices.size() ; i++) {
            this.vertices.get(i).displayVertex();
        }

        for (int i=0 ; i<this.edges.size() ; i++) {
        	this.edges.get(i).displayEdge();
        }
    }
}

public class DemoSimpleGraph {
	public static void main(String[] args) {
        SimpleGraph myGraph = new SimpleGraph();
        
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);

        myGraph.addVertex(v1);
        myGraph.addVertex(v2);
        myGraph.addVertex(v3);
        myGraph.addVertex(v4);

        myGraph.addEdge(new Edge(v1, v2));
        myGraph.addEdge(new Edge(v2, v3));
        myGraph.addEdge(new Edge(v3, v4));
        myGraph.addEdge(new Edge(v4, v1));
        myGraph.addEdge(new Edge(v1, v4));	

        myGraph.displayGraph();
    }
}