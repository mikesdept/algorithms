package datastructures.trees;

public class Node {

    private Node left;
    private Node right;
    private int value;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public int getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node node) {
        left = node;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node node) {
        right = node;
    }

    public String toString() {
        String leftString = this.left == null ? null : this.left.toString();
        String rightString = this.right == null ? null : this.right.toString();
        return "{left: " + leftString + ", right: " + rightString + ", value: " + value + "}";
    }

}
