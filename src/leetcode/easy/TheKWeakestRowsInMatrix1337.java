package leetcode.easy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TheKWeakestRowsInMatrix1337 {

    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> {
            if (a.soldiersCount == b.soldiersCount) {
                return a.index > b.index ? 1 : -1;
            } else {
                return a.soldiersCount > b.soldiersCount ? 1 : -1;
            }
        });
        for (int i = 0; i < mat.length; i++) {
            queue.add(new Pair(i, getSoldiersCount(mat[i])));
        }

        int[] result = new int[k];
        int index = 0;
        while (k > 0) {
            result[index] = queue.poll().index;
            index++;
            k--;
        }
        return result;
    }

    private int getSoldiersCount(int[] array) {
        int left = 0;
        int right = array.length - 1;
        int soldiersCount = 0;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (array[middle] == 0) {
                right = middle - 1;
            } else if (array[middle] == 1) {
                left = middle + 1;
                soldiersCount = middle + 1;
            }
        }
        return soldiersCount;
    }

    public static void main(String[] args) {
        TheKWeakestRowsInMatrix1337 theKWeakestRowsInMatrix1337 = new TheKWeakestRowsInMatrix1337();
        int[] result1 = theKWeakestRowsInMatrix1337.kWeakestRows(
                new int[][]{
                        {1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0},
                        {1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 1}
                },
                3
        );
        int[] result2 = theKWeakestRowsInMatrix1337.kWeakestRows(
                new int[][]{
                        {1, 0, 0, 0},
                        {1, 1, 1, 1},
                        {1, 0, 0, 0},
                        {1, 0, 0, 0}
                },
                2
        );
        int[] result3 = theKWeakestRowsInMatrix1337.kWeakestRows(
                new int[][]{
                        {1, 0},
                        {1, 0},
                        {1, 0},
                        {1, 1},
                },
                4
        );
        System.out.println(Arrays.toString(result1)); // [2, 0, 3]
        System.out.println(Arrays.toString(result2)); // [0, 2]
        System.out.println(Arrays.toString(result3)); // [0, 1, 2, 3]
    }

    private class Pair {
        int index;
        int soldiersCount;

        public Pair(int index, int soldiersCount) {
            this.index = index;
            this.soldiersCount = soldiersCount;
        }
    }

}
