package algorithms.binarysearch;

public class BinarySearchImplementation {

    public int search(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int indexToFind = -1;
        while (left <= right && indexToFind == -1) {
            int middle = (left + right) / 2;
            if (array[middle] == target) {
                indexToFind = middle;
            } else if (target > array[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return indexToFind;
    }

    public static void main(String[] args) {
        BinarySearchImplementation binarySearchImplementation = new BinarySearchImplementation();
        System.out.println(binarySearchImplementation.search(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 6)); // 5
        System.out.println(binarySearchImplementation.search(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 6)); // 5
        System.out.println(binarySearchImplementation.search(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 6)); // 5
        System.out.println(binarySearchImplementation.search(new int[]{1, 2, 3, 4, 5, 6, 7}, 6)); // 5
        System.out.println(binarySearchImplementation.search(new int[]{1, 2, 3, 4, 5, 6}, 6)); // 5
        System.out.println(binarySearchImplementation.search(new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10}, 6)); // 4
        System.out.println(binarySearchImplementation.search(new int[]{3, 4, 5, 6, 7, 8, 9, 10}, 6)); // 3
        System.out.println(binarySearchImplementation.search(new int[]{4, 5, 6, 7, 8, 9, 10}, 6)); // 2
        System.out.println(binarySearchImplementation.search(new int[]{5, 6, 7, 8, 9, 10}, 6)); // 1
        System.out.println(binarySearchImplementation.search(new int[]{6, 7, 8, 9, 10}, 6)); // 0
        System.out.println(binarySearchImplementation.search(new int[]{7, 8, 9, 10}, 6)); // -1
        System.out.println(binarySearchImplementation.search(new int[]{1, 2, 3, 4, 5}, 6)); // -1
    }
}
