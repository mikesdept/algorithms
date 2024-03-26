package leetcode.easy;

public class RemoveDuplicatesFromSortedList83 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode result = head;
        ListNode node = head;
        while (head != null) {
            if (node.val != head.val) {
                node.next = head;
                node = head;
            }
            head = head.next;
        }
        if (node != null) {
            node.next = null;
        }
        return result;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList83 removeDuplicatesFromSortedList83 = new RemoveDuplicatesFromSortedList83();
        ListNode listNode1 = new ListNode(1, new ListNode(1, new ListNode(2)));
        ListNode listNode2 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        System.out.println(removeDuplicatesFromSortedList83.deleteDuplicates(listNode1)); // [1, 2]
        System.out.println(removeDuplicatesFromSortedList83.deleteDuplicates(listNode2)); // [1, 2, 3]
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

        @Override
        public String toString() {
            ListNode node = this;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            while (node != null) {
                stringBuilder.append(node.val);
                stringBuilder.append(", ");
                node = node.next;
            }
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

}
