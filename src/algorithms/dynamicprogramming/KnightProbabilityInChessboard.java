package algorithms.dynamicprogramming;

public class KnightProbabilityInChessboard {

    private int[][] directions = new int[][]{{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}};

    // TODO: recheck logic once again why it works like that
    public double knightProbabilityRecursive(int n, int k, int row, int column) {
        if (n <= 0 || row < 0 || row >= n || column < 0 || column >= n) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        double result = 0;
        for (int i = 0; i < directions.length; i++) {
            result = result + (knightProbabilityRecursive(n, k - 1, row + directions[i][0], column + directions[i][1]) / 8);
        }
        return result;
    }

    // TODO: should be another solution because of time complexity is not so good for recursive solution
    public static void main(String[] args) {
        KnightProbabilityInChessboard knightProbabilityInChessboard = new KnightProbabilityInChessboard();
        System.out.println(knightProbabilityInChessboard.knightProbabilityRecursive(6, 2, 2, 2));
    }

}
