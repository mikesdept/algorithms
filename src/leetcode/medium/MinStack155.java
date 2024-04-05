package leetcode.medium;

import java.util.LinkedList;

public class MinStack155 {

    private final LinkedList<Integer> stack;
    private int min = Integer.MAX_VALUE;

    public MinStack155() {
        stack = new LinkedList<Integer>();
    }

    public void push(int val) {
        if (val <= min) {
            stack.addLast(min);
            min = val;
        }
        stack.addLast(val);
    }

    public void pop() {
        if (stack.pollLast() == min) {
            min = stack.pollLast();
        }
    }

    public int top() {
        return stack.peekLast();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack155 minStack155 = new MinStack155();
        minStack155.push(-2);
        minStack155.push(0);
        minStack155.push(-3);
        System.out.println(minStack155.getMin()); // -3
        minStack155.pop();
        System.out.println(minStack155.top()); // 0
        System.out.println(minStack155.getMin()); // -2

        MinStack155 minStack155_2 = new MinStack155();
        minStack155_2.push(0);
        minStack155_2.push(1);
        minStack155_2.push(0);
        System.out.println(minStack155_2.getMin()); // 0
        minStack155.pop();
        System.out.println(minStack155_2.getMin()); // 0
    }
}
