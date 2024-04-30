package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals56 {

    public int[][] merge(int[][] intervals) {
        List<int[]> listResult = new ArrayList<>();
        Arrays.sort(intervals, (interval1, interval2) -> {
            if (interval1[0] > interval2[0]) {
                return 1;
            } else if (interval1[0] < interval2[0]) {
                return -1;
            } else {
                return 0;
            }
        });
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            } else {
                listResult.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        listResult.add(new int[]{start, end});

        int[][] result = new int[listResult.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = listResult.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        MergeIntervals56 mergeIntervals56 = new MergeIntervals56();
        System.out.println(Arrays.deepToString(mergeIntervals56.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}))); // [[1,6],[8,10],[15,18]]
        System.out.println(Arrays.deepToString(mergeIntervals56.merge(new int[][]{{1, 4}, {4, 5}}))); // [[1,5]]
        System.out.println(Arrays.deepToString(mergeIntervals56.merge(new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}}))); // [[1,10]]
    }
}
