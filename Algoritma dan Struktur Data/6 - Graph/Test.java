public class Test {
    public static void main(String[] args){
        int N = 6;
        AdjacencyList list = new AdjacencyList(N);

        list.addEdge(0, 1);
        list.addEdge(0, 2);
        list.addEdge(1, 3);
        list.addEdge(2, 3);
        list.addEdge(2, 4);
        list.addEdge(3, 5);
        list.addEdge(4, 5);

        list.printGraph();

        list.bfs(4);
        list.dfs(4);
    }
}