package lectures.prefixamounts;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubArraySum {

    // (p[r] - p[l - 1]) % k == 0
    // p[r]%k == p[l - 1]%k
    public boolean check(int k, int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int[] prefixAmounts = new int[nums.length + 1];
        prefixAmounts[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixAmounts[i + 1] = prefixAmounts[i] + nums[i];
        }
        for (int i = 0; i < prefixAmounts.length; i++) {
            int key = prefixAmounts[i] % k;
            if (!map.containsKey(key)) {
                map.put(key, i);
            } else if (map.get(key) < i - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContinuousSubArraySum continuousSubArraySum = new ContinuousSubArraySum();
        System.out.println(continuousSubArraySum.check(6, new int[]{23, 2, 4, 6, 7})); // true
        System.out.println(continuousSubArraySum.check(7, new int[]{23, 2, 4, 6, 6})); // true
        System.out.println(continuousSubArraySum.check(1, new int[]{0})); // false
        System.out.println(continuousSubArraySum.check(2, new int[]{1, 0})); // false
        System.out.println(continuousSubArraySum.check(3, new int[]{5, 0, 0, 0})); // true
    }
}
