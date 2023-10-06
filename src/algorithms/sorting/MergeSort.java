package algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TODO: hard algorithm, should be rechecked
public class MergeSort {

    public List<Integer> mergeSort(List<Integer> array) {
        if (array.size() == 1) {
            return array;
        }
        List<Integer> left = array.subList(0, array.size() / 2);
        System.out.println("Splitting left: " + left);
        List<Integer> right = array.subList(array.size() / 2, array.size());
        System.out.println("Splitting Right: " + right);
        return merge(mergeSort(left), mergeSort(right));
    }

    private List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> merged = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < left.size() && rightIndex < right.size()) { //Keep merging until we done with one of the sides
            if (left.get(leftIndex) <= right.get(rightIndex)) { //Fixed: "<" to "<=", this what makes the merge sort "stable"
                merged.add(left.get(leftIndex));
                leftIndex++;
            } else {
                merged.add(right.get(rightIndex));
                rightIndex++;
            }
        }
        merged.addAll(left.subList(leftIndex, left.size())); //Merging all "leftovers" elements as is because we know they are sorted
        merged.addAll(right.subList(rightIndex, right.size())); //Same
        System.out.println("Merged: " + merged);
        return merged;
    }

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        System.out.println(sort.mergeSort(Arrays.asList(2, 1, 4, 3)));
    }
}
