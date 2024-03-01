package leetcode.medium;

public class UniquePaths62 {

    public int uniquePaths(int m, int n) {
        Integer[][] paths = new Integer[m][n];
        return getCountOfUniquePaths(0, 0, paths);
    }

    private int getCountOfUniquePaths(int row, int column, Integer[][] paths) {
        if (row == paths.length - 1 && column == paths[0].length - 1) {
            return 1;
        } else if (paths[row][column] != null) {
            return paths[row][column];
        } else if (column == paths[0].length - 1) {
            return getCountOfUniquePaths(row + 1, column, paths);
        } else if (row == paths.length - 1) {
            return getCountOfUniquePaths(row, column + 1, paths);
        } else {
            int countRight = getCountOfUniquePaths(row, column + 1, paths);
            int countBottom = getCountOfUniquePaths(row + 1, column, paths);
            paths[row][column] = countRight + countBottom;
            return paths[row][column];
        }
    }

    public static void main(String[] args) {
        UniquePaths62 uniquePaths62 = new UniquePaths62();
        System.out.println(uniquePaths62.uniquePaths(3, 7)); // 28
        System.out.println(uniquePaths62.uniquePaths(3, 2)); // 3
        System.out.println(uniquePaths62.uniquePaths(51, 9)); // 1916797311
    }
}
