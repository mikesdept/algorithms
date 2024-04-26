package leetcode.medium;

public class MaxAreaOfIsland695 {

    private int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, seen, i, j));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, boolean[][] seen, int row, int column) {
        seen[row][column] = true;
        int area = 1;
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newColumn = column + direction[1];
            if (newRow >= 0 && newRow < grid.length && newColumn >= 0 && newColumn < grid[0].length && grid[newRow][newColumn] == 1 && !seen[newRow][newColumn]) {
                area += dfs(grid, seen, newRow, newColumn);
            }
        }
        return area;
    }

    public static void main(String[] args) {
        MaxAreaOfIsland695 maxAreaOfIsland695 = new MaxAreaOfIsland695();
        System.out.println(maxAreaOfIsland695.maxAreaOfIsland(new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        })); // 6
        System.out.println(maxAreaOfIsland695.maxAreaOfIsland(new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0}
        })); // 0
    }
}
