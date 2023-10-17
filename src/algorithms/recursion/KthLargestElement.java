package algorithms.recursion;

// Solution is using Quick Sort plus Quick Selection (Optimal Solution)
public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return -1;
        }
        sortArray(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    public int findKthLargestOptimalSolution(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return -1;
        }
        int indexToFind = nums.length - k;
        int left = 0;
        int right = nums.length - 1;
        return sortArrayToFindKthLargest(nums, left, right, indexToFind);
    }

    private int sortArrayToFindKthLargest(int[] array, int left, int right, int indexToFind) {
        int partitionIndex = partition(array, left, right);
        if (indexToFind == partitionIndex) {
            return array[indexToFind];
        } else if (indexToFind < partitionIndex) {
            return sortArrayToFindKthLargest(array, left, partitionIndex - 1, indexToFind);
        } else {
            return sortArrayToFindKthLargest(array, partitionIndex + 1, right, indexToFind);
        }
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
        System.out.println(kthLargestElement.findKthLargestOptimalSolution(new int[]{2, 7, 8, 6, 4, 1, 9, 3, 5}, 2));
    }
}
