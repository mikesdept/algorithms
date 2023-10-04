package datastructures.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Undirected, Unweighted, Cyclic
// Adjacent List representation - use hash table
public class Graph {

    private int numberOfNodes;
    private Map<Integer, Set<Integer>> adjacentMap;

    public Graph() {
        this.numberOfNodes = 0;
        this.adjacentMap = new HashMap<>();
    }

    public void addVertex(int value) {
        Set<Integer> edges = adjacentMap.get(value);
        if (edges == null) {
            adjacentMap.put(value, new HashSet<>());
            numberOfNodes++;
        }
    }

    public void addEdge(int value1, int value2) {
        Set<Integer> value1Edges = adjacentMap.get(value1);
        Set<Integer> value2Edges = adjacentMap.get(value2);
        if (value1Edges != null && value2Edges != null) {
            value1Edges.add(value2);
            value2Edges.add(value1);
        }
    }

    public void showConnections() {
        Object[] nodes = adjacentMap.keySet().toArray();
        for (Object node : nodes) {
            System.out.println(node + " -> " + adjacentMap.get((Integer) node));
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex(0);
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(2);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 1);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.showConnections();
        // output should be:
        // 0 -> [2]
        // 1 -> [2, 3]
        // 2 -> [0, 1, 3]
        // 3 -> [1, 2]
    }

}
