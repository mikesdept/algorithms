package algorithms.sorting;

import java.util.Arrays;
import java.util.LinkedList;

public class InsertionSort {

    public Integer[] insertionSort(Integer[] array) {
        if (array == null) {
            return null;
        }
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(array));
        for (int i = 1; i < list.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (list.get(i) < list.get(j)) {
                    Integer value = list.remove(i);
                    list.add(j, value);
                    break;
                }
            }
        }
        return list.toArray(new Integer[0]);
    }

    public static void main(String[] args) {
        InsertionSort sort = new InsertionSort();
        System.out.println(Arrays.toString(sort.insertionSort(null)));
        System.out.println(Arrays.toString(sort.insertionSort(new Integer[]{1})));
        System.out.println(Arrays.toString(sort.insertionSort(new Integer[]{1, 2})));
        System.out.println(Arrays.toString(sort.insertionSort(new Integer[]{2, 1})));
        System.out.println(Arrays.toString(sort.insertionSort(new Integer[]{1, 3, 2, 6, 4, 1, 9, 5, 8}))); // 1 1 2 3 4 5 6 8 9
    }

}
