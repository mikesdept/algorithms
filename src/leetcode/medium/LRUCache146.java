package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache146 {

    private final Map<Integer, Node> map = new HashMap<>();
    private final int capacity;

    private Node head;
    private Node tail;

    public LRUCache146(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            moveExistingToTail(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            moveExistingToTail(node);
            map.put(key, node);
        } else if (map.size() < capacity) {
            Node node = new Node(key, value);
            if (head == null && tail == null) {
                head = node;
                tail = node;
            } else {
                addNewToTail(node);
            }
            map.put(key, node);
        } else {
            map.remove(head.key);
            Node node = new Node(key, value);
            if (capacity == 1) {
                head = node;
                tail = node;
            } else {
                head = head.next;
                addNewToTail(node);
            }
            map.put(key, node);
        }
    }

    private void moveExistingToTail(Node node) {
        if (node != tail) {
            if (node == head) {
                head = head.next;
                head.previous = null;

                node.next = null;
                node.previous = tail;
                tail.next = node;
                tail = node;
            } else {
                node.previous.next = node.next;
                node.next.previous = node.previous;

                node.next = null;
                node.previous = tail;
                tail.next = node;
                tail = node;
            }
        }
    }

    private void addNewToTail(Node node) {
        tail.next = node;
        node.previous = tail;
        tail = node;
    }

    private static class Node {
        int key;
        int val;
        Node previous;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LRUCache146 lruCache1 = new LRUCache146(2);
        lruCache1.put(1, 1);
        lruCache1.put(2, 2);
        System.out.println(lruCache1.get(1)); // 1
        lruCache1.put(3, 3);
        System.out.println(lruCache1.get(2)); // -1
        lruCache1.put(4, 4);
        System.out.println(lruCache1.get(1)); // -1
        System.out.println(lruCache1.get(3)); // 3
        System.out.println(lruCache1.get(4)); // 4

        System.out.println("==========");

        LRUCache146 lruCache2 = new LRUCache146(3);
        lruCache2.put(1, 1);
        lruCache2.put(2, 2);
        lruCache2.put(3, 3);
        lruCache2.put(4, 4);
        System.out.println(lruCache2.get(4)); // 4
        System.out.println(lruCache2.get(3)); // 3
        System.out.println(lruCache2.get(2)); // 2
        System.out.println(lruCache2.get(1)); // -1
        lruCache2.put(5, 5);
        System.out.println(lruCache2.get(1)); // -1
        System.out.println(lruCache2.get(2)); // 2
        System.out.println(lruCache2.get(3)); // 3
        System.out.println(lruCache2.get(4)); // -1
        System.out.println(lruCache2.get(5)); // 5
    }
}
