package algorithms.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdjacencyListDFS {

    public void traverse(int value, int[][] graph, List<Integer> values, Set<Integer> seen) {
        seen.add(value);
        values.add(value);
        for (int i = 0; i < graph[value].length; i++) {
            if (!seen.contains(graph[value][i])) {
                traverse(graph[value][i], graph, values, seen);
            }
        }
    }

    public static void main(String[] args) {
        AdjacencyListDFS adjacencyListBFS = new AdjacencyListDFS();
        List<Integer> values = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        int[][] graph = new int[][]{{1, 3}, {0}, {3, 8}, {0, 2, 4, 5}, {3, 6}, {3}, {4, 7}, {6}, {2}};
        adjacencyListBFS.traverse(0, graph, values, seen);
        System.out.println(values); // [0, 1, 3, 2, 8, 4, 6, 7, 5]
    }
}
