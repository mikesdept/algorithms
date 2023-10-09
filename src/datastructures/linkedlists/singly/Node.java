package datastructures.linkedlists.singly;

public class Node {

    private Node next;
    private int value;

    public Node(int value) {
        this.next = null;
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

}
