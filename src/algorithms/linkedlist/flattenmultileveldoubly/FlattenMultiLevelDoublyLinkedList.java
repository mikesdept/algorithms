package algorithms.linkedlist.flattenmultileveldoubly;

public class FlattenMultiLevelDoublyLinkedList {

    //   1   2   3   4
    //       5   6
    //       7
    // output: 1 2 5 7 6 3 4
    public Node flatten3(Node head) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.child == null) {
                currentNode = currentNode.next;
            } else {
                Node child = currentNode.child;
                while (child.next != null) {
                    child = child.next;
                }
                child.next = currentNode.next;
                if (child.next != null) {
                    child.next.prev = child;
                }
                currentNode.next = currentNode.child;
                currentNode.child.prev = currentNode;
                currentNode.child = null;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        FlattenMultiLevelDoublyLinkedList flatten = new FlattenMultiLevelDoublyLinkedList();

        Node node1 = new Node();
        node1.val = 1;

        Node node2 = new Node();
        node2.val = 2;

        Node node5 = new Node();
        node5.val = 5;

        Node node6 = new Node();
        node6.val = 6;

        Node node3 = new Node();
        node3.val = 3;

        Node node4 = new Node();
        node4.val = 4;

        Node node7 = new Node();
        node7.val = 7;

        node1.next = node2;
        node2.child = node5;
        node5.next = node6;
        node5.child = node7;
        node2.next = node3;
        node3.next = node4;

        Node node = flatten.flatten3(node1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}
