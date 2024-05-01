package leetcode.medium;

public class ReorderList143 {

    public ListNode reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;

        ListNode next = null;
        ListNode temp = null;
        while (second != null) {
            temp = second.next;
            second.next = next;
            next = second;
            second = temp;
        }

        ListNode firstNode = head;
        ListNode secondNode = next;
        while (secondNode != null) {
            next = firstNode.next;
            firstNode.next = secondNode;
            firstNode = next;

            next = secondNode.next;
            secondNode.next = firstNode;
            secondNode = next;
        }
        return head;
    }

    public static void main(String[] args) {
        ReorderList143 reorderList143 = new ReorderList143();
        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))); // 1 4 2 3
        ListNode listNode2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))); // 1 5 2 4 3
        System.out.println(reorderList143.reorderList(listNode1));
        System.out.println(reorderList143.reorderList(listNode2));
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

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            ListNode node = this;
            while (node != null) {
                stringBuilder.append(node.val).append(" ");
                node = node.next;
            }
            return stringBuilder.toString();
        }
    }

}
