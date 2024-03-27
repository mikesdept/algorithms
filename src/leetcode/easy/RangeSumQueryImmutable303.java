package leetcode.easy;

public class RangeSumQueryImmutable303 {

    private int[] prefixSum;

    public RangeSumQueryImmutable303(int[] nums) {
        prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefixSum[right] - (left == 0 ? 0 : prefixSum[left - 1]);
    }

    public static void main(String[] args) {
        RangeSumQueryImmutable303 rangeSumQueryImmutable303 = new RangeSumQueryImmutable303(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(rangeSumQueryImmutable303.sumRange(0, 2)); // 1
        System.out.println(rangeSumQueryImmutable303.sumRange(2, 5)); // -1
        System.out.println(rangeSumQueryImmutable303.sumRange(0, 5)); // -3
    }
}
