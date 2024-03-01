package leetcode.medium;

public class UniquePaths63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        Integer[][] cache = new Integer[obstacleGrid.length][obstacleGrid[0].length];
        return findUniquePathsCount(obstacleGrid, 0, 0, cache);
    }

    private int findUniquePathsCount(int[][] grid, int row, int column, Integer[][] cache) {
        if (cache[row][column] != null) {
            return cache[row][column];
        } else if (grid[row][column] == 1) {
            return 0;
        } else if (row == grid.length - 1 && column == grid[0].length - 1) {
            return 1;
        } else if (row == grid.length - 1) {
            return findUniquePathsCount(grid, row, column + 1, cache);
        } else if (column == grid[0].length - 1) {
            return findUniquePathsCount(grid, row + 1, column, cache);
        } else {
            int rightCount = findUniquePathsCount(grid, row, column + 1, cache);
            int bottomCount = findUniquePathsCount(grid, row + 1, column, cache);
            cache[row][column] = rightCount + bottomCount;
            return cache[row][column];
        }
    }

    public static void main(String[] args) {
        UniquePaths63 uniquePaths63 = new UniquePaths63();
        System.out.println(uniquePaths63.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}})); // 2
        System.out.println(uniquePaths63.uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}})); // 1
        System.out.println(uniquePaths63.uniquePathsWithObstacles(new int[][]{{0, 0}, {0, 1}})); // 0
    }
}
