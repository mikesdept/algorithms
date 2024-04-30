package leetcode.medium;

public class LinkedListCycle142 {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }

        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        LinkedListCycle142 linkedListCycle142 = new LinkedListCycle142();
        ListNode listNode11 = new ListNode(3);
        ListNode listNode12 = new ListNode(2);
        ListNode listNode13 = new ListNode(0);
        ListNode listNode14 = new ListNode(-4);
        listNode11.next = listNode12;
        listNode12.next = listNode13;
        listNode13.next = listNode14;
        listNode14.next = listNode12;
        System.out.println(linkedListCycle142.detectCycle(listNode11).val); // 2

        ListNode listNode21 = new ListNode(1);
        ListNode listNode22 = new ListNode(2);
        listNode21.next = listNode22;
        listNode22.next = listNode21;
        System.out.println(linkedListCycle142.detectCycle(listNode21).val); // 1

        ListNode listNode31 = new ListNode(1);
        System.out.println(linkedListCycle142.detectCycle(listNode31)); // null
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
