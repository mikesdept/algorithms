package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfConnectedComponentsInUndirectedGraph323 {

    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            List<Integer> list1 = map.getOrDefault(node1, new ArrayList<>());
            List<Integer> list2 = map.getOrDefault(node2, new ArrayList<>());
            list1.add(node2);
            list2.add(node1);
            map.put(node1, list1);
            map.put(node2, list2);
        }

        boolean[] visited = new boolean[n];
        int componentsCount = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                componentsCount++;
                dfs(map, visited, i);
            }
        }
        return componentsCount;
    }

    private void dfs(Map<Integer, List<Integer>> map, boolean[] visited, int node) {
        visited[node] = true;
        for (int childNode : map.getOrDefault(node, new ArrayList<>())) {
            if (!visited[childNode]) {
                dfs(map, visited, childNode);
            }
        }
    }

    public static void main(String[] args) {
        NumberOfConnectedComponentsInUndirectedGraph323 numberOfConnectedComponentsInUndirectedGraph323 = new NumberOfConnectedComponentsInUndirectedGraph323();
        System.out.println(numberOfConnectedComponentsInUndirectedGraph323.countComponents(
                5, new int[][]{
                        {0, 1},
                        {1, 2},
                        {3, 4}
                }
        )); // 2
    }
}
