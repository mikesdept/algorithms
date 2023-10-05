package algorithms.sorting;

import java.util.Arrays;

public class BubbleSort {

    public int[] bubbleSort(int[] array) {
        if (array == null) {
            return array;
        }
        int checkedLength = array.length;
        while (checkedLength >= 2) {
            for (int i = 1; i < checkedLength; i++) {
                if (array[i - 1] > array[i]) {
                    int left = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = left;
                }
            }
            checkedLength--;
        }
        return array;
    }

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        System.out.println(Arrays.toString(sort.bubbleSort(null)));
        System.out.println(Arrays.toString(sort.bubbleSort(new int[]{})));
        System.out.println(Arrays.toString(sort.bubbleSort(new int[]{1})));
        System.out.println(Arrays.toString(sort.bubbleSort(new int[]{1, 2})));
        System.out.println(Arrays.toString(sort.bubbleSort(new int[]{2, 1})));
        System.out.println(Arrays.toString(sort.bubbleSort(new int[]{1, 3, 2, 7, 4, 2, 1, 8, 7, 8})));
    }
}
