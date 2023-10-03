package datastructures.arrays.mergesortedarrays;

class MergeSortedArrays {

    public Integer[] mergeArrays(Integer[] array1, Integer[] array2) {
        if (array1 == null || array1.length == 0) {
            return array2;
        }
        if (array2 == null || array2.length == 0) {
            return array1;
        }
        int arrayIndex1 = 0;
        int arrayIndex2 = 0;
        int mergedArrayIndex = 0;
        Integer[] mergedArrays = new Integer[array1.length + array2.length];
        while (mergedArrayIndex < mergedArrays.length) {
            if (arrayIndex2 == array2.length || (arrayIndex1 < array1.length && array1[arrayIndex1] < array2[arrayIndex2])) {
                mergedArrays[mergedArrayIndex] = array1[arrayIndex1];
                mergedArrayIndex++;
                arrayIndex1++;
            } else {
                mergedArrays[mergedArrayIndex] = array2[arrayIndex2];
                mergedArrayIndex++;
                arrayIndex2++;
            }
        }
        return mergedArrays;
    }

    public static void main(String[] args) {
        MergeSortedArrays mergeSortedArrays = new MergeSortedArrays();
        Integer[] array1 = new Integer[]{0, 3, 3, 5, 9, 12, 14};
        Integer[] array2 = new Integer[]{1, 2, 3, 7, 10, 11, 12, 13, 14, 15};
        Integer[] mergedSortedArrays = mergeSortedArrays.mergeArrays(array1, array2);
        for (int i = 0; i < mergedSortedArrays.length; i++) {
            System.out.println("item [" + i + "] = " + mergedSortedArrays[i]);
        }
    }

}
