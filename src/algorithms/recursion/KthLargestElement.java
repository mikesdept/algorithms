package algorithms.recursion;

public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return -1;
        }
        sortArray(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    private void sortArray(int[] array, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(array, left, right);
            sortArray(array, left, partitionIndex - 1);
            sortArray(array, partitionIndex + 1, right);
        }
    }

    private int partition(int[] array, int left, int right) {
        int partitionIndex = left;
        for (int i = left; i <= right; i++) {
            if (array[i] < array[right]) {
                replaceElements(i, partitionIndex, array);
                partitionIndex++;
            }
        }
        replaceElements(partitionIndex, right, array);
        return partitionIndex;
    }

    private void replaceElements(int index1, int index2, int[] array) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        KthLargestElement kthLargestElement = new KthLargestElement();
        System.out.println(kthLargestElement.findKthLargest(new int[]{2, 7, 8, 6, 4, 1, 9, 3, 5}, 2));
    }
}