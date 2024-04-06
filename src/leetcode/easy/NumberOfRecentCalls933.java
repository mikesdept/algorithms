package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfRecentCalls933 {

    private final Queue<Integer> queue;

    public NumberOfRecentCalls933() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }

    public static void main(String[] args) {
        NumberOfRecentCalls933 numberOfRecentCalls933 = new NumberOfRecentCalls933();
        System.out.println(numberOfRecentCalls933.ping(1)); // 1
        System.out.println(numberOfRecentCalls933.ping(100)); // 2
        System.out.println(numberOfRecentCalls933.ping(3001)); // 3
        System.out.println(numberOfRecentCalls933.ping(3002)); // 3
    }
}
