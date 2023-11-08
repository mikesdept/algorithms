package algorithms.graph;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class AdjacencyListBFS {

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
                    queue.add(graph[value][i]);
                }
            }
            seen.add(value);
        }
        return values;
    }

    public static void main(String[] args) {
        AdjacencyListBFS adjacencyListBFS = new AdjacencyListBFS();
        List<Integer> result = adjacencyListBFS.traverse(new int[][]{{1, 3}, {0}, {3, 8}, {0, 2, 4, 5}, {3, 6}, {3}, {4, 7}, {6}, {2}});
        System.out.println(result); // [0, 1, 3, 2, 4, 5, 8, 6, 7]
    }
}
