package leetcode.medium;

public class AddTwoNumbers2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode node = result;
        int inMemoryVal = 0;
        while (l1 != null || l2 != null) {
            int first = l1 == null ? 0 : l1.val;
            int second = l2 == null ? 0 : l2.val;
            int currentVal = (first + second + inMemoryVal) % 10;
            inMemoryVal = (first + second + inMemoryVal) / 10;

            ListNode nextNode = new ListNode(currentVal);
            node.next = nextNode;
            node = nextNode;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (inMemoryVal > 0) {
            node.next = new ListNode(inMemoryVal);
        }
        return result.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers2 addTwoNumbers2 = new AddTwoNumbers2();

        ListNode l11 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l12 = new ListNode(5, new ListNode(6, new ListNode(4)));
        System.out.println(addTwoNumbers2.addTwoNumbers(l11, l12)); // [7, 0, 8]

        ListNode l21 = new ListNode(0);
        ListNode l22 = new ListNode(0);
        System.out.println(addTwoNumbers2.addTwoNumbers(l21, l22)); // [0]

        ListNode l31 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))); // [7, 0, 8]
        ListNode l32 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))); // [0]
        System.out.println(addTwoNumbers2.addTwoNumbers(l31, l32)); // [8, 9, 9, 9, 0, 0, 0, 1]
    }

    public static class ListNode {

        int val;
        ListNode next;

        public ListNode() {
        }

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
