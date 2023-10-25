package algorithms.twodarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BFS2DArray {

    private final int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public List<Integer> traverse(int[][] array) {
        boolean[][] seenElements = new boolean[array.length][array[0].length];
        for (int i = 0; i < seenElements.length; i++) {
            Arrays.fill(seenElements[i], false);
        }
        List<Integer> values = new ArrayList<>();
        Queue<Integer[]> queue = new LinkedBlockingQueue<>();
        queue.add(new Integer[]{array.length / 2, array[0].length / 2});
        bfs(array, seenElements, queue, values);
        return values;
    }

    private void bfs(int[][] array, boolean[][] seenElements, Queue<Integer[]> queue, List<Integer> values) {
        while (!queue.isEmpty() || values.size() < array.length * array[0].length) {
            Integer[] indexes = queue.poll();
            int i = indexes[0];
            int j = indexes[1];

            if (!seenElements[i][j]) {
                seenElements[i][j] = true;
                values.add(array[i][j]);
            }
            for (int directionsIndex = 0; directionsIndex < directions.length; directionsIndex++) {
                int indexI = i + directions[directionsIndex][0];
                int indexJ = j + directions[directionsIndex][1];
                if (!(indexI < 0 || indexI >= array.length || indexJ < 0 || indexJ >= array[0].length || seenElements[indexI][indexJ])) {
                    queue.add(new Integer[]{indexI, indexJ});
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}};
        BFS2DArray BFS2DArray = new BFS2DArray();
        List<Integer> traversedArray = BFS2DArray.traverse(array);
        System.out.println(traversedArray); // 13, 8, 14, 18, 12, 3, 9, 7, 15, 19, 17, 11, 4, 2, 10, 6, 20, 16, 5, 1
    }
}
