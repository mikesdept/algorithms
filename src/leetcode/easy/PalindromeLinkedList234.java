package leetcode.easy;

import java.util.LinkedList;

public class PalindromeLinkedList234 {

    public boolean isPalindrome(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<>();
        ListNode node = head;
        while (node != null) {
            stack.addLast(node.val);
            node = node.next;
        }
        while (head != null) {
            if (head.val != stack.pollLast()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public boolean isPalindromeOptimalSolution(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode halfNode = getHalf(head);
        ListNode halfReversedNode = reverse(halfNode.next);

        ListNode startNode = head;

        while (halfReversedNode != null) {
            if (startNode.val != halfReversedNode.val) {
                return false;
            }
            startNode = startNode.next;
            halfReversedNode = halfReversedNode.next;
        }
        return true;
    }

    private ListNode getHalf(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode node) {
        ListNode temp;
        ListNode next = null;
        while (node != null) {
            temp = node.next;
            node.next = next;
            next = node;
            node = temp;
        }
        return next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        ListNode listNode2 = new ListNode(1, new ListNode(2));

        PalindromeLinkedList234 palindromeLinkedList234 = new PalindromeLinkedList234();
        System.out.println(palindromeLinkedList234.isPalindrome(listNode1)); // true
        System.out.println(palindromeLinkedList234.isPalindrome(listNode2)); // false
        System.out.println(palindromeLinkedList234.isPalindromeOptimalSolution(listNode1)); // true
        System.out.println(palindromeLinkedList234.isPalindromeOptimalSolution(listNode2)); // false
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
