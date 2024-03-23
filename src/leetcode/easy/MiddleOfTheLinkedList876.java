package leetcode.easy;

public class MiddleOfTheLinkedList876 {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        MiddleOfTheLinkedList876 middleOfTheLinkedList876 = new MiddleOfTheLinkedList876();
        System.out.println(middleOfTheLinkedList876.middleNode(listNode1).val); // 3
        System.out.println(middleOfTheLinkedList876.middleNode(listNode2).val); // 4
    }

    public static class ListNode {
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
