package algorithms.graph;

import java.util.ArrayList;
import java.util.List;

public class TimeNeededToInformAllEmployees {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int i = 0; i < manager.length; i++) {
            int managerValue = manager[i];
            if (managerValue != -1) {
                List<Integer> managerList = adjacencyList.get(managerValue);
                managerList.add(i);
            }
        }
        System.out.println(adjacencyList);
        return dfs(headID, adjacencyList, informTime);
    }

    private int dfs(int current, List<List<Integer>> adjacencyList, int[] informTime) {
        List<Integer> values = adjacencyList.get(current);
        int max = 0;
        for (int i = 0; i < values.size(); i++) {
            max = Math.max(max, dfs(values.get(i), adjacencyList, informTime));
        }
        int currentTime = informTime[current];
        return max + currentTime;
    }

    public static void main(String[] args) {
        TimeNeededToInformAllEmployees timeNeededToInformAllEmployees = new TimeNeededToInformAllEmployees();
        System.out.println(timeNeededToInformAllEmployees.numOfMinutes(8, 4, new int[]{2, 2, 4, 6, -1, 4, 4, 5}, new int[]{0, 0, 4, 0, 7, 3, 6, 0}));
    }

}
