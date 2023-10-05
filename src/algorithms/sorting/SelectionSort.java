package algorithms.sorting;

import java.util.Arrays;

public class SelectionSort {

    // 2 1 5 3
    // from 0 to length - 1 -> [0] = 1
    // from 1 to length - 1

    public int[] selectionSort(int[] array) {
        if (array == null) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        SelectionSort sort = new SelectionSort();
        System.out.println(Arrays.toString(sort.selectionSort(null)));
        System.out.println(Arrays.toString(sort.selectionSort(new int[]{1})));
        System.out.println(Arrays.toString(sort.selectionSort(new int[]{1, 2})));
        System.out.println(Arrays.toString(sort.selectionSort(new int[]{2, 1})));
        System.out.println(Arrays.toString(sort.selectionSort(new int[]{1, 4, 2, 1, 2, 8, 4, 6, 9, 6})));
    }

}
