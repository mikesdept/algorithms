package algorithms.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdjacencyMatrixDFS {

    public void traverse(int value, int[][] graph, List<Integer> values, Set<Integer> seen) {
        seen.add(value);
        values.add(value);
        for (int i = 0; i < graph[value].length; i++) {
            if (graph[value][i] == 1 && !seen.contains(i)) {
                traverse(i, graph, values, seen);
            }
        }
    }

    public static void main(String[] args) {
        AdjacencyMatrixDFS adjacencyMatrixBFS = new AdjacencyMatrixDFS();
        List<Integer> values = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        int[][] graph = new int[][]{
                {0, 1, 0, 1, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0}
        };
        adjacencyMatrixBFS.traverse(0, graph, values, seen);
        System.out.println(values); // [0, 1, 3, 2, 8, 4, 6, 7, 5]
    }

}
