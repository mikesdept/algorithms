package leetcode.medium;

public class MinimumPathSum64 {

    public int minPathSum1(int[][] grid) {
        Integer[][] result = new Integer[grid.length][grid[0].length];
        return findMinPathSum(grid, 0, 0, result);
    }

    public int minPathSum2(int[][] grid) {
        Integer[][] result = new Integer[grid.length][grid[0].length];
        findMinPathSum(grid, result);
        return result[result.length - 1][result[0].length - 1];
    }

    private int findMinPathSum(int[][] grid, int row, int column, Integer[][] result) {
        if (row == grid.length - 1 && column == grid[0].length - 1) {
            return grid[row][column];
        } else if (result[row][column] != null) {
            return result[row][column];
        } else if (column == grid[0].length - 1) {
            return grid[row][column] + findMinPathSum(grid, row + 1, column, result);
        } else if (row == grid.length - 1) {
            return grid[row][column] + findMinPathSum(grid, row, column + 1, result);
        } else {
            int rightCount = findMinPathSum(grid, row, column + 1, result);
            int downCount = findMinPathSum(grid, row + 1, column, result);
            int minPathSum = grid[row][column] + Math.min(rightCount, downCount);
            result[row][column] = minPathSum;
            return minPathSum;
        }
    }

    private void findMinPathSum(int[][] grid, Integer[][] result) {
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if (row == 0 && column == 0) {
                    result[row][column] = grid[row][column];
                } else if (row == 0) {
                    result[row][column] = result[row][column - 1] + grid[row][column];
                } else if (column == 0) {
                    result[row][column] = result[row - 1][column] + grid[row][column];
                } else {
                    result[row][column] = Math.min(result[row][column - 1], result[row - 1][column]) + grid[row][column];
                }
            }
        }
    }

    public static void main(String[] args) {
        MinimumPathSum64 minimumPathSum64 = new MinimumPathSum64();
        System.out.println(minimumPathSum64.minPathSum1(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}})); // 7
        System.out.println(minimumPathSum64.minPathSum1(new int[][]{{1, 2, 3}, {4, 5, 6}})); // 12
        System.out.println(minimumPathSum64.minPathSum2(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}})); // 7
        System.out.println(minimumPathSum64.minPathSum2(new int[][]{{1, 2, 3}, {4, 5, 6}})); // 12
    }

}
