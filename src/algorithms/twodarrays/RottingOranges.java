package algorithms.twodarrays;

import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class RottingOranges {

    private int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        int freshOranges = 0;
        Queue<Integer[]> rottenQueue = new LinkedBlockingQueue<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    freshOranges++;
                } else if (grid[i][j] == 2) {
                    rottenQueue.add(new Integer[]{i, j});
                }
            }
        }
        int rottenQueueSizeLevel = rottenQueue.size();
        int minutes = 0;
        boolean[][] taken = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < taken.length; i++) {
            Arrays.fill(taken[i], false);
        }
        while (!rottenQueue.isEmpty()) {
            if (rottenQueueSizeLevel == 0) {
                rottenQueueSizeLevel = rottenQueue.size();
                minutes++;
            }
            Integer[] indexes = rottenQueue.poll();
            int i = indexes[0];
            int j = indexes[1];
            if (grid[i][j] == 1) {
                freshOranges--;
            }
            grid[i][j] = 2;
            rottenQueueSizeLevel--;
            for (int directionsIndex = 0; directionsIndex < directions.length; directionsIndex++) {
                int indexIShift = i + directions[directionsIndex][0];
                int indexJShift = j + directions[directionsIndex][1];
                if (!(indexIShift < 0 || indexIShift >= grid.length || indexJShift < 0 || indexJShift >= grid[0].length || grid[indexIShift][indexJShift] == 0 || grid[indexIShift][indexJShift] == 2 || taken[indexIShift][indexJShift])) {
                    rottenQueue.add(new Integer[]{indexIShift, indexJShift});
                    taken[indexIShift][indexJShift] = true;
                }
            }
        }
        if (freshOranges > 0) {
            return -1;
        } else {
            return minutes;
        }
    }

    // 2 2
    // 1 1
    // 0 0
    // 2 0
    public static void main(String[] args) {
        RottingOranges rottingOranges = new RottingOranges();
        System.out.println(rottingOranges.orangesRotting(new int[][]{{2, 1, 1, 0, 0}, {1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 1, 0, 0, 1}}));
        System.out.println(rottingOranges.orangesRotting(new int[][]{{1, 1, 0, 0, 0}, {2, 1, 0, 0, 0}, {0, 0, 0, 1, 2}, {0, 1, 0, 0, 1}}));
        System.out.println(rottingOranges.orangesRotting(new int[][]{{2, 2}, {1, 1}, {0, 0}, {2, 0}}));
        System.out.println(rottingOranges.orangesRotting(new int[][]{{}}));
    }

}
