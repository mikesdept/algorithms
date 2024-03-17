package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        row.add(1);
        rows.add(row);
        for (int i = 2; i <= numRows; i++) {
            List<Integer> rowItem = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    rowItem.add(1);
                } else {
                    rowItem.add(rows.get(i - 2).get(j - 1) + rows.get(i - 2).get(j));
                }
            }
            rows.add(rowItem);
        }
        return rows;
    }

    public static void main(String[] args) {
        PascalsTriangle118 pascalsTriangle118 = new PascalsTriangle118();
        System.out.println(pascalsTriangle118.generate(5)); // [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]
        System.out.println(pascalsTriangle118.generate(1)); // [[1]]
    }
}
