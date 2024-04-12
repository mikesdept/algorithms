package leetcode.medium;

import java.util.LinkedList;

public class DesignCircularDeque641 {

    private final LinkedList<Integer> ll;
    private final int k;
    private int count;

    public DesignCircularDeque641(int k) {
        this.ll = new LinkedList<>();
        this.k = k;
        this.count = 0;
    }

    public boolean insertFront(int value) {
        if (count == k) {
            return false;
        } else {
            count++;
            ll.addFirst(value);
            return true;
        }
    }

    public boolean insertLast(int value) {
        if (count == k) {
            return false;
        } else {
            count++;
            ll.add(value);
            return true;
        }
    }

    public boolean deleteFront() {
        if (count == 0) {
            return false;
        } else {
            count--;
            ll.poll();
            return true;
        }
    }

    public boolean deleteLast() {
        if (count == 0) {
            return false;
        } else {
            count--;
            ll.pollLast();
            return true;
        }
    }

    public int getFront() {
        if (count == 0) {
            return -1;
        } else {
            return ll.peek();
        }
    }

    public int getRear() {
        if (count == 0) {
            return -1;
        } else {
            return ll.peekLast();
        }
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == k;
    }

    public static void main(String[] args) {
        DesignCircularDeque641 designCircularDeque641 = new DesignCircularDeque641(3);
        System.out.println(designCircularDeque641.insertLast(1)); // true
        System.out.println(designCircularDeque641.insertLast(2)); // true
        System.out.println(designCircularDeque641.insertFront(3)); // true
        System.out.println(designCircularDeque641.insertFront(4)); // false
        System.out.println(designCircularDeque641.getRear()); // 2
        System.out.println(designCircularDeque641.isFull()); // true
        System.out.println(designCircularDeque641.deleteLast()); // true
        System.out.println(designCircularDeque641.insertFront(4)); // true
        System.out.println(designCircularDeque641.getFront()); // 4
    }
}
