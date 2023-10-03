package datastructures.queues;

import datastructures.stacks.Node;

public class QueueUsingLinkedList {

    private Node firstNode;
    private Node lastNode;
    private int length;

    public QueueUsingLinkedList() {
        firstNode = null;
        lastNode = null;
        length = 0;
    }

    public Integer peek() {
        Integer value = null;
        if (!isEmpty()) {
            value = firstNode.getValue();
        }
        return value;
    }

    public void enqueue(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            firstNode = node;
            lastNode = node;
        } else {
            lastNode.setNext(node);
            lastNode = node;
        }
        length++;
    }

    public Integer dequeue() {
        Integer value = null;
        if (firstNode == lastNode) {
            lastNode = null;
        }
        if (!isEmpty()) {
            value = firstNode.getValue();
            firstNode = firstNode.getNext();
            length--;
        }
        return value;
    }

    public boolean isEmpty() {
        return firstNode == null && lastNode == null && length == 0;
    }

    public int getLength() {
        return length;
    }

    public static void main(String[] args) {
        QueueUsingLinkedList stack = new QueueUsingLinkedList();
        stack.enqueue(1);
        stack.enqueue(2);
        stack.enqueue(3);
        System.out.println("length -> " + stack.getLength());
        System.out.println("peek -> " + stack.peek());
        System.out.println("length -> " + stack.getLength());
        System.out.println("dequeue -> " + stack.dequeue());
        System.out.println("length -> " + stack.getLength());
        System.out.println("isEmpty -> " + stack.isEmpty());
        System.out.println("dequeue -> " + stack.dequeue());
        System.out.println("length -> " + stack.getLength());
        System.out.println("isEmpty -> " + stack.isEmpty());
        System.out.println("dequeue -> " + stack.dequeue());
        System.out.println("length -> " + stack.getLength());
        System.out.println("isEmpty -> " + stack.isEmpty());
        System.out.println("dequeue -> " + stack.dequeue());
        System.out.println("length -> " + stack.getLength());
        System.out.println("isEmpty -> " + stack.isEmpty());
        /*
        output should be:
        length -> 3
        peek -> 1
        length -> 3
        dequeue -> 1
        length -> 2
        isEmpty -> false
        dequeue -> 2
        length -> 1
        isEmpty -> false
        dequeue -> 3
        length -> 0
        isEmpty -> true
        dequeue -> null
        length -> 0
        isEmpty -> true
         */
    }

}
