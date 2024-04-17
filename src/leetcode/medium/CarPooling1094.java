package leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CarPooling1094 {

    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> a[1] > b[1] ? 1 : -1);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] > b[2] ? 1 : -1);

        int currentCapacity = 0;
        for (int i = 0; i < trips.length; i++) {
            while (!queue.isEmpty() && queue.peek()[2] <= trips[i][1]) {
                currentCapacity -= queue.poll()[0];
            }
            currentCapacity += trips[i][0];
            if (currentCapacity > capacity) {
                return false;
            } else {
                queue.add(trips[i]);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CarPooling1094 carPooling1094 = new CarPooling1094();
        System.out.println(carPooling1094.carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4)); // false
        System.out.println(carPooling1094.carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 5)); // true
    }
}
