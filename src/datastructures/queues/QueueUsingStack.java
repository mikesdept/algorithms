package datastructures.queues;

import java.util.Stack;

public class QueueUsingStack {

    private final Stack<Integer> queue = new Stack<>();
    private final Stack<Integer> reversedQueue = new Stack<>();

    public void enqueue(int value) {
        if (queue.size() == 0) {
            queue.push(value);
        } else {
            while (queue.size() != 0) {
                reversedQueue.push(queue.pop());
            }
            reversedQueue.push(value);
            while (reversedQueue.size() != 0) {
                queue.push(reversedQueue.pop());
            }
        }
    }

    public Integer peek() {
        if (queue.size() != 0) {
            return queue.peek();
        } else {
            return null;
        }
    }

    public Integer dequeue() {
        if (queue.size() != 0) {
            return queue.pop();
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("item -> " + queue.peek());
        System.out.println("item -> " + queue.dequeue());
        System.out.println("item -> " + queue.dequeue());
        System.out.println("item -> " + queue.dequeue());
        System.out.println("item -> " + queue.dequeue());
        // output should be: 1 1 2 3 null
    }

}
