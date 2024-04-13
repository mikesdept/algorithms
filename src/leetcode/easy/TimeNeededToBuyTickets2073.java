package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class TimeNeededToBuyTickets2073 {

    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int ticket : tickets) {
            queue.add(ticket);
        }

        int position = k;
        int time = 0;
        while (!queue.isEmpty()) {
            time++;
            int ticket = queue.poll() - 1;
            if (ticket == 0) {
                if (position == 0) {
                    break;
                }
            } else {
                queue.add(ticket);
                if (position == 0) {
                    position = queue.size();
                }
            }
            position--;
        }

        return time;
    }

    public int timeRequiredToBuyOptimizedSolution(int[] tickets, int k) {
        int time = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (i == k) {
                time += tickets[i];
            } else if (i < k) {
                time += Math.min(tickets[i], tickets[k]);
            } else {
                time += Math.min(tickets[i], tickets[k] - 1);
            }
        }
        return time;
    }

    public static void main(String[] args) {
        TimeNeededToBuyTickets2073 timeNeededToBuyTickets2073 = new TimeNeededToBuyTickets2073();
        System.out.println(timeNeededToBuyTickets2073.timeRequiredToBuy(new int[]{2, 3, 2}, 2)); // 6
        System.out.println(timeNeededToBuyTickets2073.timeRequiredToBuy(new int[]{5, 1, 1, 1}, 0)); // 8
        System.out.println(timeNeededToBuyTickets2073.timeRequiredToBuyOptimizedSolution(new int[]{2, 3, 2}, 2)); // 6
        System.out.println(timeNeededToBuyTickets2073.timeRequiredToBuyOptimizedSolution(new int[]{5, 1, 1, 1}, 0)); // 8
    }
}
