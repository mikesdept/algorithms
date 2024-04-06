package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues225 {

    private final Queue<Integer> queue;

    public ImplementStackUsingQueues225() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        Queue<Integer> tempQueue = new LinkedList<>();
        while (!queue.isEmpty()) {
            tempQueue.add(queue.poll());
        }
        queue.add(x);
        while (!tempQueue.isEmpty()) {
            queue.add(tempQueue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackUsingQueues225 implementStackUsingQueues225 = new ImplementStackUsingQueues225();
        implementStackUsingQueues225.push(1);
        implementStackUsingQueues225.push(2);
        System.out.println(implementStackUsingQueues225.top()); // 2
        System.out.println(implementStackUsingQueues225.pop()); // 2
        System.out.println(implementStackUsingQueues225.empty()); // false
    }
}
