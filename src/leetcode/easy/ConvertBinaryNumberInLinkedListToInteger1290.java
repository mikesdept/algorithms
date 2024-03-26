package leetcode.easy;

public class ConvertBinaryNumberInLinkedListToInteger1290 {

    public int getDecimalValue(ListNode head) {
        int pow = -1;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            pow++;
        }

        int result = 0;
        while (head != null) {
            int bit = head.val;
            if (bit == 1) {
                result += 1 << pow;
            }
            head = head.next;
            pow--;
        }
        return result;
    }

    public static void main(String[] args) {
        ConvertBinaryNumberInLinkedListToInteger1290 convertBinaryNumberInLinkedListToInteger1290 = new ConvertBinaryNumberInLinkedListToInteger1290();
        ListNode listNode1 = new ListNode(1, new ListNode(0, new ListNode(1)));
        ListNode listNode2 = new ListNode(0);
        ListNode listNode3 = new ListNode(1, new ListNode(0, new ListNode(0, new ListNode(1, new ListNode(0, new ListNode(0, new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0)))))))))))))));
        System.out.println(convertBinaryNumberInLinkedListToInteger1290.getDecimalValue(listNode1)); // 5
        System.out.println(convertBinaryNumberInLinkedListToInteger1290.getDecimalValue(listNode2)); // 0
        System.out.println(convertBinaryNumberInLinkedListToInteger1290.getDecimalValue(listNode3)); // 18880
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
