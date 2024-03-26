package leetcode.easy;

public class RemoveLinkedListElements203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode node = new ListNode(val + 1, head);
        ListNode result = node;
        ListNode cache = node;
        while (node != null) {
            if (node.val != val) {
                if (cache != node) {
                    cache.next = node;
                }
                cache = node;
            }
            node = node.next;
        }
        cache.next = null;
        return result.next;
    }

    public static void main(String[] args) {
        RemoveLinkedListElements203 removeLinkedListElements203 = new RemoveLinkedListElements203();
        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
        ListNode listNode2 = null;
        ListNode listNode3 = new ListNode(7, new ListNode(7, new ListNode(7, new ListNode(7))));
        System.out.println(removeLinkedListElements203.removeElements(listNode1, 6)); // [1, 2, 3, 4, 5]
        System.out.println(removeLinkedListElements203.removeElements(listNode2, 1)); // null
        System.out.println(removeLinkedListElements203.removeElements(listNode3, 7)); // null
    }

    public static class ListNode {
        int val;
        ListNode next;

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
            stringBuilder.append("[");
            ListNode node = this;
            while (node != null) {
                stringBuilder.append(node.val);
                stringBuilder.append(",");
                node = node.next;
            }
            stringBuilder.append("]");
            return stringBuilder.toString();
        }

    }

}
