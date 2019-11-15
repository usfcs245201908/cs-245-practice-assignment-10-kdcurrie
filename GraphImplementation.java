import java.util.*;

public class GraphImplementation implements Graph {
    private int [][] adjMatrix;
    private int vertices;

    public GraphImplementation(int vertices) {
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices];
    }

    public void addEdge(int src, int tar) {
            adjMatrix[src][tar] = 1;
    }

    public List<Integer> topologicalSort(){
        List<Integer> list = new ArrayList<Integer>();
        int [] sum = new int[vertices];

        for (int i = 0; i < vertices; i++){
            for (int j = 0; j <  vertices; j++){
                sum[i] += adjMatrix[j][i];
            }
        }
        for (int i = 0; i <  vertices; i++){
            int next = findZero(sum);

            list.add(next);
            sum[next] = -1;
            for (int j = 0; j <  vertices; j++) {
                sum[j] -= adjMatrix[next][j];
            }
        }
        return list;
    }

    public List<Integer> neighbors(int vertex){
        List<Integer> neighbors = new ArrayList<Integer>();

        for (int i = 0; i <  vertices; i++) {
            if (adjMatrix[vertex][i] > 0) {
                neighbors.add(i);
            }
        }
        return neighbors;
    }

    private int findZero(int [] sum) {
        for (int i = 0; i <  sum.length; i++) {
            if (sum[i] == 0)
                return i;
        }
        return -1;
    }
}
