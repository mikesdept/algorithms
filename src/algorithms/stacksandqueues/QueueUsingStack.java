package algorithms.stacksandqueues;

import java.util.Stack;

public class QueueUsingStack {
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        System.out.println(obj.empty()); // false
        System.out.println(obj.pop()); // 1
        System.out.println(obj.peek()); // 2
        System.out.println(obj.empty()); // false
        System.out.println(obj.pop()); // 2
        System.out.println(obj.peek()); // 3
        System.out.println(obj.empty()); // false
        System.out.println(obj.pop()); // 3
        System.out.println(obj.empty()); // true
        System.out.println(obj.peek()); // exception
        System.out.println(obj.pop()); // exception
        System.out.println(obj.peek()); // exception
    }

    static class MyQueue {

        private final Stack<Integer> stack;

        public MyQueue() {
            stack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
        }

        public int pop() {
            Stack<Integer> stackReversed = new Stack<>();
            while (!empty()) {
                stackReversed.add(stack.pop());
            }
            int value = stackReversed.pop();
            while (!stackReversed.isEmpty()) {
                stack.push(stackReversed.pop());
            }
            return value;
        }

        public int peek() {
            return stack.get(0);
        }

        public boolean empty() {
            return stack.isEmpty();
        }

    }

}
