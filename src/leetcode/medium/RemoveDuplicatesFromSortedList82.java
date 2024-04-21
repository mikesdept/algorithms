package leetcode.medium;

public class RemoveDuplicatesFromSortedList82 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode previousUnique = dummy;
        ListNode node = head;
        while (node != null) {
            if (node.next != null && node.val == node.next.val) {
                while (node.next != null && node.val == node.next.val) {
                    node = node.next;
                }
            } else {
                previousUnique.next = node;
                previousUnique = node;
            }
            node = node.next;
        }
        previousUnique.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList82 removeDuplicatesFromSortedList82 = new RemoveDuplicatesFromSortedList82();
        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
        ListNode listNode2 = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))));
        System.out.println(removeDuplicatesFromSortedList82.deleteDuplicates(listNode1)); // 1, 2, 5
        System.out.println(removeDuplicatesFromSortedList82.deleteDuplicates(listNode2)); // 2, 3
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
            ListNode node = this;
            StringBuilder stringBuilder = new StringBuilder();
            while (node != null) {
                stringBuilder.append(node.val);
                stringBuilder.append(", ");
                node = node.next;
            }
            return stringBuilder.toString();
        }
    }

}
