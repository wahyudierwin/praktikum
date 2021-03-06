public class Graph{
    private int numVertex;
    private int[][] adjacencyMatrix;

    public Graph(int numVertex){
        this.numVertex = numVertex;
        this.adjacencyMatrix = new int[numVertex][numVertex];
    }

    public void addEdge(int from, int to, int weight){
        this.adjacencyMatrix[from][to] = weight;
        this.adjacencyMatrix[to][from] = weight;
    }

    public void displayGraph(){
        for (int i=0 ; i<numVertex ; i++){
            for (int j=0 ; j<numVertex ; j++){
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void dijkstra(int src, int dst){
        int[] distance = new int[numVertex];
        boolean[] fixed = new boolean[numVertex];

        for (int i=0 ; i<numVertex ; i++){
            distance[i] = Integer.MAX_VALUE;
            fixed[i] = false;
        }

        distance[src] = 0;
        while(true){
            int marked = minIndex(distance, fixed);
            if (marked < 0) break;
            if (distance[marked] == Integer.MAX_VALUE) break;

            fixed[marked] = true;

            for (int j=0 ; j<numVertex ; j++){
                if (adjacencyMatrix[marked][j] > 0 && !fixed[j]){
                    int newDistance = distance[marked] + adjacencyMatrix[marked][j];

                    if (newDistance < distance[j]){
                        distance[j] = newDistance;
                    }
                }
            }
        }

        if (distance[dst] == Integer.MAX_VALUE){
            System.out.println("no route");
        }
        else{
            System.out.println("distance="+distance[dst]);
        }
    }

    private int minIndex(int[] distance, boolean[] fixed){
        int idx = 0;
        for (;idx < fixed.length ; idx++){
            if (!fixed[idx]) break;
        }
        if (idx == fixed.length) return -1;
        for (int i = idx+1 ; i<fixed.length ; i++){
            if (!fixed[i] && distance[i] < distance[idx]){
                idx = i;
            }
        }
        return idx;
    }
}
