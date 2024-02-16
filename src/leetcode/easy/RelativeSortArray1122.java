package leetcode.easy;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class RelativeSortArray1122 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        int currentResultIndex = 0;
        int[] result = new int[arr1.length];
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            int count = 1;
            if (map.containsKey(arr1[i])) {
                count += map.get(arr1[i]);
            }
            map.put(arr1[i], count);
        }
        for (int i = 0; i < arr2.length; i++) {
            int searchValue = arr2[i];
            int countOfRepeatedSearchValue = getCountOfRepeatedSearchValue(searchValue, arr1);
            int startIndex = currentResultIndex;
            map.remove(searchValue);
            for (int j = startIndex; j < startIndex + countOfRepeatedSearchValue; j++) {
                result[j] = searchValue;
                currentResultIndex++;
            }
        }
        if (!map.isEmpty()) {
            for (Map.Entry<Integer, Integer> mapEntry : map.entrySet()) {
                int value = mapEntry.getKey();
                int count = mapEntry.getValue();
                for (int i = 0; i < count; i++) {
                    result[currentResultIndex] = value;
                    currentResultIndex++;
                }
            }
        }
        return result;
    }

    private int getCountOfRepeatedSearchValue(int searchValue, int[] array) {
        int left = 0;
        int right = array.length - 1;
        int searchIndex = -1;
        while (left <= right) {
            int index = (left + right) / 2;
            if (searchValue > array[index]) {
                left = index + 1;
            } else if (searchValue < array[index]) {
                right = index - 1;
            } else {
                searchIndex = index;
                break;
            }
        }
        int leftIndex = searchIndex;
        while (leftIndex >= 0 && array[leftIndex] == searchValue) {
            leftIndex--;
        }
        int rightIndex = searchIndex;
        while (rightIndex < array.length && array[rightIndex] == searchValue) {
            rightIndex++;
        }
        leftIndex++;
        rightIndex--;
        return rightIndex - leftIndex + 1;
    }

    public int[] r_relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new TreeMap<>();
        int[] result = new int[arr1.length];
        int resultIndex = 0;
        for (int number : arr1) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        for (int number : arr2) {
            for (int i = 0; i < map.get(number); i++) {
                result[resultIndex] = number;
                resultIndex++;
            }
            map.remove(number);
        }
        for (int number : map.keySet()) {
            for (int i = 0; i < map.get(number); i++) {
                result[resultIndex] = number;
                resultIndex++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RelativeSortArray1122 relativeSortArray1122 = new RelativeSortArray1122();
        System.out.println(Arrays.toString(relativeSortArray1122.relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6}))); // [2,2,2,1,4,3,3,9,6,7,19]
        System.out.println(Arrays.toString(relativeSortArray1122.relativeSortArray(new int[]{28, 6, 22, 8, 44, 17}, new int[]{22, 28, 8, 6}))); // [22,28,8,6,17,44]

        System.out.println(Arrays.toString(relativeSortArray1122.r_relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6}))); // [2,2,2,1,4,3,3,9,6,7,19]
        System.out.println(Arrays.toString(relativeSortArray1122.r_relativeSortArray(new int[]{28, 6, 22, 8, 44, 17}, new int[]{22, 28, 8, 6}))); // [22,28,8,6,17,44]
    }

}
