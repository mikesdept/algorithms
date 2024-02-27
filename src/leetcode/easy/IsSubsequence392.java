package leetcode.easy;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class IsSubsequence392 {

    public boolean isSubsequence(String s, String t) {
        Queue<Character> queue = new LinkedBlockingQueue<>();
        for (int i = 0; i < s.length(); i++) {
            queue.add(s.charAt(i));
        }
        int tIndex = 0;
        while (!queue.isEmpty() && tIndex < t.length()) {
            if (queue.peek() == t.charAt(tIndex)) {
                queue.poll();
            }
            tIndex++;
        }
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        IsSubsequence392 isSubsequence392 = new IsSubsequence392();
        System.out.println(isSubsequence392.isSubsequence("abc", "ahbgdc")); // true
        System.out.println(isSubsequence392.isSubsequence("axc", "ahbgdc")); // false
    }

}
