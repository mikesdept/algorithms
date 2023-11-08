package algorithms.graph;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class AdjacencyMatrixBFS {

    public List<Integer> traverse(int[][] graph) {
        Queue<Integer> queue = new LinkedBlockingQueue<>();
        queue.add(0);
        List<Integer> values = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        while (!queue.isEmpty()) {
            int value = queue.poll();
            if (!seen.contains(value)) {
                values.add(value);
                for (int i = 0; i < graph[value].length; i++) {
                    if (graph[value][i] == 1) {
                        queue.add(i);
                    }
                }
            }
            seen.add(value);
        }
        return values;
    }

    public static void main(String[] args) {
        AdjacencyMatrixBFS adjacencyMatrixBFS = new AdjacencyMatrixBFS();
        List<Integer> result = adjacencyMatrixBFS.traverse(new int[][]{
                {0, 1, 0, 1, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0}
        });
        System.out.println(result); // [0, 1, 3, 2, 4, 5, 8, 6, 7]
    }

}
