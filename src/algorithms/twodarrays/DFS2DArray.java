package algorithms.twodarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFS2DArray {

    private int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public List<Integer> traverse(int[][] array) {
        boolean[][] seenElements = new boolean[array.length][array[0].length];
        for (int i = 0; i < seenElements.length; i++) {
            Arrays.fill(seenElements[i], false);
        }
        List<Integer> values = new ArrayList<>();
        dfs(array, seenElements, values, 0, 0);
        return values;
    }

    private void dfs(int[][] array, boolean[][] seenElements, List<Integer> values, int i, int j) {
        if (i < 0 || i >= array.length || j < 0 || j >= array[0].length || seenElements[i][j]) {
            return;
        }
        values.add(array[i][j]);
        seenElements[i][j] = true;
        for (int directionIndex = 0; directionIndex < directions.length; directionIndex++) {
            dfs(array, seenElements, values, i + directions[directionIndex][0], j + directions[directionIndex][1]);
        }
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        DFS2DArray DFS2DArray = new DFS2DArray();
        List<Integer> traversedArray = DFS2DArray.traverse(array);
        System.out.println(traversedArray); // 1, 2, 3, 4, 8, 12, 16, 15, 11, 7, 6, 10, 14, 13, 9, 5
    }

}
