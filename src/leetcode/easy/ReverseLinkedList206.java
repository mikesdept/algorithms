package leetcode.easy;

public class ReverseLinkedList206 {

    public ListNode reverseList(ListNode head) {
        ListNode node = head;
        ListNode next = null;
        while (node != null) {
            ListNode temp = node.next;
            node.next = next;
            next = node;
            node = temp;
        }
        return next;
    }

    public static void main(String[] args) {
        ReverseLinkedList206 reverseLinkedList206 = new ReverseLinkedList206();
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode reversedNode = reverseLinkedList206.reverseList(node);
        while (reversedNode != null) {
            System.out.println(reversedNode.val);
            reversedNode = reversedNode.next;
        }
        // 5 4 3 2 1
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
