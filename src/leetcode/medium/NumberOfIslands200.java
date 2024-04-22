package leetcode.medium;

public class NumberOfIslands200 {

    private int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        return calculate(grid);
    }

    private int calculate(char[][] grid) {
        int counter = 0;
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    counter++;
                    dfs(grid, seen, new int[]{i, j});
                }
            }
        }
        return counter;
    }

    private void dfs(char[][] grid, boolean[][] seen, int[] point) {
        grid[point[0]][point[1]] = '0';
        seen[point[0]][point[1]] = true;
        for (int i = 0; i < directions.length; i++) {
            int rowIndex = point[0] + directions[i][0];
            int columnIndex = point[1] + directions[i][1];
            if (!(rowIndex < 0 || rowIndex >= grid.length || columnIndex < 0 || columnIndex >= grid[0].length || seen[rowIndex][columnIndex] || grid[rowIndex][columnIndex] == '0')) {
                dfs(grid, seen, new int[]{rowIndex, columnIndex});
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid1 = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
        };
        char[][] grid2 = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'},
        };
        NumberOfIslands200 numberOfIslands200 = new NumberOfIslands200();
        System.out.println(numberOfIslands200.numIslands(grid1)); // 1
        System.out.println(numberOfIslands200.numIslands(grid2)); // 3
    }
}
