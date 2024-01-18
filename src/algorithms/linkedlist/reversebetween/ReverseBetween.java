package algorithms.linkedlist.reversebetween;

public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode lastLeftOutsideRange = null;
        ListNode current = head;
        int currentIndex = 1;
        while (currentIndex < left) {
            lastLeftOutsideRange = current;
            current = current.next;
            currentIndex++;
        }
        ListNode lastRightInsideRange = current;
        ListNode previous = null;
        while (currentIndex <= right) {
            ListNode next = current.next;
            if (left == currentIndex) {
                previous = current;
                current = next;
            } else {
                current.next = previous;
                previous = current;
                current = next;
            }
            currentIndex++;
        }
        if (lastLeftOutsideRange != null) {
            lastLeftOutsideRange.next = previous;
        } else {
            head = previous;
        }
        lastRightInsideRange.next = current;
        return head;
    }

    public ListNode reverseBetweenV2(ListNode head, int left, int right) {
        if (right - left == 0) {
            return head;
        }
        ListNode lastLeftOutsideRange = left > 1 ? head : null;
        int leftIndexCounter = 1;
        while (leftIndexCounter < left - 1) {
            leftIndexCounter++;
            lastLeftOutsideRange = lastLeftOutsideRange.next;
        }
        ListNode current = lastLeftOutsideRange == null ? head : lastLeftOutsideRange.next;
        ListNode lastRightInsideRange = current;
        ListNode next = null;
        for (int i = 0; i < (right - left + 1); i++) {
            ListNode previous = current.next;
            current.next = next;
            next = current;
            current = previous;
        }
        if (lastLeftOutsideRange != null) {
            lastLeftOutsideRange.next = next;
        } else {
            head = next;
        }
        lastRightInsideRange.next = current;
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ReverseBetween reverseBetween = new ReverseBetween();
        ListNode reversedNode = reverseBetween.reverseBetween(node, 2, 4);
        while (reversedNode != null) {
            System.out.println(reversedNode.val);
            reversedNode = reversedNode.next;
        }

        System.out.println("==========");

        ListNode node2 = new ListNode(3, new ListNode(5));
        ListNode reversedNode2 = reverseBetween.reverseBetweenV2(node2, 1, 2);
        while (reversedNode2 != null) {
            System.out.println(reversedNode2.val);
            reversedNode2 = reversedNode2.next;
        }
    }

}
