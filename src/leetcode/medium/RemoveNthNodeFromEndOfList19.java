package leetcode.medium;

public class RemoveNthNodeFromEndOfList19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }

        int nodeToDeleteIndex = count - n;

        if (nodeToDeleteIndex == 0 && count == 1) {
            return null;
        } else if (nodeToDeleteIndex == 0 && count > 1) {
            return head.next;
        } else {
            int currentNodeIndex = 0;
            ListNode currentNode = head;
            while (currentNodeIndex < nodeToDeleteIndex - 1) {
                currentNode = currentNode.next;
                currentNodeIndex++;
            }
            currentNode.next = currentNode.next.next;
            return head;
        }
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList19 removeNthNodeFromEndOfList19 = new RemoveNthNodeFromEndOfList19();
        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(1, new ListNode(2));
        System.out.println(removeNthNodeFromEndOfList19.removeNthFromEnd(listNode1, 2)); // [1, 2, 3, 5]
        System.out.println(removeNthNodeFromEndOfList19.removeNthFromEnd(listNode2, 1)); // []
        System.out.println(removeNthNodeFromEndOfList19.removeNthFromEnd(listNode3, 1)); // [1]
    }

    public static class ListNode {

        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
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
