package datastructures.linkedlists.doubly;

public class Node {

    private Node previousNode;
    private Node nextNode;
    private int value;

    public Node(int value) {
        this.previousNode = null;
        this.nextNode = null;
        this.value = value;
    }

    public Node getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Node previousNode) {
        this.previousNode = previousNode;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public int getValue() {
        return value;
    }

}
