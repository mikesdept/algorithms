package leetcode.medium;

import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class SurroundedRegions130 {

    private int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void solve(char[][] board) {
        boolean[][] seen = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O' && !seen[i][j]) {
                    bfsRegion(i, j, board, seen);
                }
            }
        }
    }

    public void solveOptimalSolution(char[][] board) {
        boolean[][] seen = new boolean[board.length][board[0].length];

        for (int row = 1; row < board.length - 1; row++) {
            if (board[row][0] == 'O' && board[row][1] == 'O' && !seen[row][1]) {
                dfs(row, 1, board, seen);
            }
            if (board[row][board[0].length - 1] == 'O' && board[row][board[0].length - 2] == 'O' && !seen[row][board[0].length - 2]) {
                dfs(row, board[0].length - 2, board, seen);
            }
        }

        for (int column = 1; column < board[0].length - 1; column++) {
            if (board[0][column] == 'O' && board[1][column] == 'O' && !seen[1][column]) {
                dfs(1, column, board, seen);
            }
            if (board[board.length - 1][column] == 'O' && board[board.length - 2][column] == 'O' && !seen[board.length - 2][column]) {
                dfs(board.length - 2, column, board, seen);
            }
        }

        for (int row = 1; row < board.length - 1; row++) {
            for (int column = 1; column < board[0].length - 1; column++) {
                if (board[row][column] == 'O' && !seen[row][column]) {
                    board[row][column] = 'X';
                }
            }
        }
    }

    private void bfsRegion(int startRow, int startColumn, char[][] board, boolean[][] seen) {
        Queue<int[]> queue = new LinkedBlockingQueue<>();
        queue.add(new int[]{startRow, startColumn});
        boolean isBorderRegion = false;
        Stack<int[]> regionPositions = new Stack<>();
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            seen[position[0]][position[1]] = true;
            if (position[0] == 0 || position[0] == board.length - 1 || position[1] == 0 || position[1] == board[0].length - 1) {
                isBorderRegion = true;
            }
            if (!isBorderRegion) {
                regionPositions.push(position);
            }
            for (int[] direction : directions) {
                int row = position[0] + direction[0];
                int column = position[1] + direction[1];
                if (row >= 0 && row < board.length && column >= 0 && column < board[0].length && !seen[row][column] && board[row][column] == 'O') {
                    queue.add(new int[]{row, column});
                }
            }
        }
        if (!isBorderRegion) {
            while (!regionPositions.isEmpty()) {
                int[] cachedPosition = regionPositions.pop();
                board[cachedPosition[0]][cachedPosition[1]] = 'X';
            }
        }
    }

    private void dfs(int startRow, int startColumn, char[][] board, boolean[][] seen) {
        seen[startRow][startColumn] = true;
        for (int[] direction : directions) {
            int row = startRow + direction[0];
            int column = startColumn + direction[1];
            if (row >= 1 && row < board.length - 1 && column >= 1 && column < board[0].length - 1 && !seen[row][column] && board[row][column] == 'O') {
                dfs(row, column, board, seen);
            }
        }
    }

    public static void main(String[] args) {
        SurroundedRegions130 surroundedRegions130 = new SurroundedRegions130();
        char[][] charArray1 = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
        };
        char[][] charArray2 = new char[][]{{'X'}};
        char[][] charArray3 = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
        };
        char[][] charArray4 = new char[][]{{'X'}};
        surroundedRegions130.solve(charArray1);
        surroundedRegions130.solve(charArray2);
        surroundedRegions130.solveOptimalSolution(charArray3);
        surroundedRegions130.solveOptimalSolution(charArray4);
        System.out.println(Arrays.deepToString(charArray1)); // expected only one 'O' at the bottom
        System.out.println(Arrays.deepToString(charArray2)); // expected array is the same as before
        System.out.println(Arrays.deepToString(charArray3)); // expected only one 'O' at the bottom
        System.out.println(Arrays.deepToString(charArray4)); // expected array is the same as before
    }
}
