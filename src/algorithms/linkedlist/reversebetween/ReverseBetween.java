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

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ReverseBetween reverseBetween = new ReverseBetween();
        ListNode reversedNode = reverseBetween.reverseBetween(node, 2, 4);
        while (reversedNode != null) {
            System.out.println(reversedNode.val);
            reversedNode = reversedNode.next;
        }
    }

}
