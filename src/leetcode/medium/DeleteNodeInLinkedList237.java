package leetcode.medium;

public class DeleteNodeInLinkedList237 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(4);
        ListNode listNode1Delete = listNode1.next = new ListNode(5);
        listNode1Delete.next = new ListNode(1);
        listNode1Delete.next.next = new ListNode(9);
        ListNode listNode2 = new ListNode(4);
        listNode2.next = new ListNode(5);
        ListNode listNode2Delete = listNode2.next.next = new ListNode(1);
        listNode2Delete.next = new ListNode(9);

        DeleteNodeInLinkedList237 deleteNodeInLinkedList237 = new DeleteNodeInLinkedList237();
        deleteNodeInLinkedList237.deleteNode(listNode1Delete);
        deleteNodeInLinkedList237.deleteNode(listNode2Delete);

        ListNode node1 = listNode1;
        while (node1 != null) {
            System.out.println(node1.val);
            node1 = node1.next;
        }
        // 4, 1, 9
        System.out.println("==========");
        // 4, 5, 9
        ListNode node2 = listNode2;
        while (node2 != null) {
            System.out.println(node2.val);
            node2 = node2.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            this.next = next;
        }
    }

}
