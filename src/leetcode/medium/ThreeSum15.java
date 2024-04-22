package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int targetSum = -nums[i];
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int currentSum = nums[left] + nums[right];
                    if (currentSum < targetSum) {
                        left++;
                    } else if (currentSum > targetSum) {
                        right--;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum15 threeSum15 = new ThreeSum15();
        System.out.println(threeSum15.threeSum(new int[]{-1, 0, 1, 2, -1, -4})); // [[-1,-1,2],[-1,0,1]]
        System.out.println(threeSum15.threeSum(new int[]{0, 1, 1})); // []
        System.out.println(threeSum15.threeSum(new int[]{0, 0, 0})); // [0, 0, 0]
    }
}
