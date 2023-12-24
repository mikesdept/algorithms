package lectures.prefixamounts;

import java.util.ArrayList;
import java.util.List;

public class SumWithMinLengthOfArray {

    public List<Integer> getMinLengthSubArray(int t, int[] array) {
        if (array == null) {
            return null;
        }
        int[] prefixAmounts = new int[array.length];
        prefixAmounts[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            prefixAmounts[i] = prefixAmounts[i - 1] + array[i];
        }
        int firstIndex = 0;
        int secondIndex = 0;
        List<Integer> result = new ArrayList<>();
        while (firstIndex < array.length && secondIndex < array.length) {
            int prefixSumLeft;
            if (firstIndex == 0) {
                prefixSumLeft = 0;
            } else {
                prefixSumLeft = prefixAmounts[firstIndex - 1];
            }
            int prefixSumRight = prefixAmounts[secondIndex];
            int prefixSum = prefixSumRight - prefixSumLeft;
            if (prefixSum >= t) {
                int length = secondIndex - firstIndex + 1;
                if (result.isEmpty() || result.size() > length) {
                    result.clear();
                    for (int i = firstIndex; i <= secondIndex; i++) {
                        result.add(array[i]);
                    }
                }
                firstIndex++;
            } else {
                if (result.isEmpty() || result.size() > (secondIndex - firstIndex + 1)) {
                    secondIndex++;
                } else {
                    firstIndex++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SumWithMinLengthOfArray sumWithMinLengthOfArray = new SumWithMinLengthOfArray();
        System.out.println(sumWithMinLengthOfArray.getMinLengthSubArray(7, new int[]{2, 3, 1, 2, 4, 3})); // 4, 3
        System.out.println(sumWithMinLengthOfArray.getMinLengthSubArray(6, new int[]{2, 3, 1, 2, 4, 3})); // 2, 4
        System.out.println(sumWithMinLengthOfArray.getMinLengthSubArray(8, new int[]{2, 3, 1, 2, 4, 3})); // 2, 4, 3
        System.out.println(sumWithMinLengthOfArray.getMinLengthSubArray(8, null)); // null
    }

}
