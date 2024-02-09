package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones771 {

    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }
        for (int i = 0; i < stones.length(); i++) {
            if (set.contains(stones.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        JewelsAndStones771 jewelsAndStones771 = new JewelsAndStones771();
        System.out.println(jewelsAndStones771.numJewelsInStones("aA", "aAAbbbb")); // 3
        System.out.println(jewelsAndStones771.numJewelsInStones("z", "ZZ")); // 0
    }

}
