import java.util.LinkedList;
import java.util.Iterator;

public class AdjacencyList {
    int N;
    LinkedList<Integer> adjListArray[];

    AdjacencyList(int N){
        this.N = N;
        adjListArray = new LinkedList[N];

        for (int i=0 ; i<N ; i++){
            this.adjListArray[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int from, int to){
        this.adjListArray[from].add(to);
        this.adjListArray[to].add(from);
    }

    public void printGraph(){
        for (int n=0 ; n<N ; n++){
            System.out.print("Adjacency List Node-" + n);
            System.out.print(": head");

            for (Integer i: this.adjListArray[n]){
                System.out.print(" -> " + i);
            }
            System.out.println();
        }
    }

    public void bfs(int start){
        boolean[] visited = new boolean[N];
        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[start] = true;
        queue.add(start);

        while(queue.size() != 0){
            start = queue.poll();
            System.out.print(start + " ");

            Iterator<Integer> i = adjListArray[start].listIterator();
            while (i.hasNext()){
                int n = i.next();
                if (!visited[n]){
                    queue.add(n);
                    visited[n] = true;
                }
            }
        }
        System.out.println();
    }

    public void dfs(int start){
        boolean[] visited = new boolean[N];
        _dfs(start, visited);
        System.out.println();
    }

    private void _dfs(int vertex, boolean[] visited){
        System.out.print(vertex + " ");
        visited[vertex] = true;

        for (Integer i: this.adjListArray[vertex]){
            if (!visited[i]){
                _dfs(i, visited);
            }
        }
    }
}