package algorithms.twodarrays;

import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class NumberOfIslands {

    private int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int numIslandsBfs(char[][] grid) {
        int numIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    islandDetectedBfs(grid, i, j);
                }
            }
        }
        return numIslands;
    }

    public int numIslandsDfs(char[][] grid) {
        int numIslands = 0;
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        for (int seenIndex = 0; seenIndex < seen.length; seenIndex++) {
            Arrays.fill(seen[seenIndex], false);
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    islandDetectedDfs(grid, seen, i, j);
                }
            }
        }
        return numIslands;
    }

    private void islandDetectedBfs(char[][] grid, int i, int j) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        for (int seenIndex = 0; seenIndex < seen.length; seenIndex++) {
            Arrays.fill(seen[seenIndex], false);
        }
        Queue<Integer[]> queue = new LinkedBlockingQueue<>();
        queue.add(new Integer[]{i, j});
        while (!queue.isEmpty()) {
            Integer[] indexes = queue.poll();
            int indexI = indexes[0];
            int indexJ = indexes[1];
            grid[indexI][indexJ] = '0';
            seen[indexI][indexJ] = true;
            for (int directionsIndex = 0; directionsIndex < directions.length; directionsIndex++) {
                int indexIShift = indexI + directions[directionsIndex][0];
                int indexJShift = indexJ + directions[directionsIndex][1];
                if (!(indexIShift < 0 || indexIShift >= grid.length || indexJShift < 0 || indexJShift >= grid[0].length || seen[indexIShift][indexJShift] || grid[indexIShift][indexJShift] == '0')) {
                    queue.add(new Integer[]{indexIShift, indexJShift});
                }
            }
        }
    }

    private void islandDetectedDfs(char[][] array, boolean[][] seen, int indexI, int indexJ) {
        if (indexI < 0 || indexI >= array.length || indexJ < 0 || indexJ >= array[0].length || seen[indexI][indexJ] || array[indexI][indexJ] == '0') {
            return;
        }
        seen[indexI][indexJ] = true;
        array[indexI][indexJ] = '0';
        for (int i = 0; i < directions.length; i++) {
            islandDetectedDfs(array, seen, indexI + directions[i][0], indexJ + directions[i][1]);
        }
    }

    public static void main(String[] args) {
        char[][] firstBfs = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '1'}, {'0', '0', '0', '1', '1'}};
        char[][] secondBfs = new char[][]{{'0', '1', '0', '1', '0'}, {'1', '0', '1', '0', '1'}, {'0', '1', '1', '1', '0'}, {'1', '0', '1', '0', '1'}};
        char[][] firstDfs = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '1'}, {'0', '0', '0', '1', '1'}};
        char[][] secondDfs = new char[][]{{'0', '1', '0', '1', '0'}, {'1', '0', '1', '0', '1'}, {'0', '1', '1', '1', '0'}, {'1', '0', '1', '0', '1'}};
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        System.out.println(numberOfIslands.numIslandsBfs(firstBfs)); // 2
        System.out.println(numberOfIslands.numIslandsBfs(secondBfs)); // 7
        System.out.println(numberOfIslands.numIslandsDfs(firstDfs)); // 2
        System.out.println(numberOfIslands.numIslandsDfs(secondDfs)); // 7
    }

}
