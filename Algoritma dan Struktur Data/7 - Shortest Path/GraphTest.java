public class GraphTest{
    public static void main(String[] args){
        int numVertex = 8;
        Graph graph = new Graph(numVertex);

        graph.addEdge(0,1,1);
        graph.addEdge(0,2,7);
        graph.addEdge(0,3,2);
        graph.addEdge(1,4,2);
        graph.addEdge(1,5,4);
        graph.addEdge(2,5,2);
        graph.addEdge(2,6,3);
        graph.addEdge(3,6,5);
        graph.addEdge(4,5,1);
        graph.addEdge(5,7,6);
        graph.addEdge(6,7,2);

        graph.displayGraph();

        graph.dijkstra(0,7);
    }
}