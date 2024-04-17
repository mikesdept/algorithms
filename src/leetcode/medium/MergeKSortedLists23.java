package leetcode.medium;

import java.util.PriorityQueue;

public class MergeKSortedLists23 {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val > b.val ? 1 : -1);
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        ListNode head = null;
        ListNode current = null;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            if (head == null) {
                head = node;
            } else {
                current.next = node;
            }
            if (node.next != null) {
                queue.add(node.next);
            }
            current = node;
        }
        return head;
    }

    public static void main(String[] args) {
        MergeKSortedLists23 mergeKSortedLists23 = new MergeKSortedLists23();
        ListNode listNode1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode3 = new ListNode(2, new ListNode(6));

        ListNode node = mergeKSortedLists23.mergeKLists(new ListNode[]{listNode1, listNode2, listNode3});
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
        // 1 1 2 3 4 4 5 6
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
