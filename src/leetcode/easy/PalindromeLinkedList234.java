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

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        ListNode listNode2 = new ListNode(1, new ListNode(2));

        PalindromeLinkedList234 palindromeLinkedList234 = new PalindromeLinkedList234();
        System.out.println(palindromeLinkedList234.isPalindrome(listNode1)); // true
        System.out.println(palindromeLinkedList234.isPalindrome(listNode2)); // false
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
