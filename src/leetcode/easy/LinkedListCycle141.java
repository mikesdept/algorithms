package leetcode.easy;

public class LinkedListCycle141 {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedListCycle141 linkedListCycle141 = new LinkedListCycle141();
        ListNode node11 = new ListNode(3);
        ListNode node12 = new ListNode(2);
        ListNode node13 = new ListNode(0);
        ListNode node14 = new ListNode(-4);
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        node14.next = node12;
        System.out.println(linkedListCycle141.hasCycle(node11)); // true

        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(2);
        node21.next = node22;
        node22.next = node21;
        System.out.println(linkedListCycle141.hasCycle(node21)); // true

        ListNode node31 = new ListNode(1);
        System.out.println(linkedListCycle141.hasCycle(node31)); // false

        ListNode node41 = new ListNode(1);
        node41.next = new ListNode(2);
        System.out.println(linkedListCycle141.hasCycle(node41)); // false
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
