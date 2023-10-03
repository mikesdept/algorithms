package datastructures.stacks;

public class StackUsingLinkedList {

    private Node bottomNode;
    private Node topNode;
    private int length;

    public Integer peek() {
        Integer value;
        if (topNode != null) {
            value = topNode.getValue();
        } else {
            value = null;
        }
        return value;
    }

    public void push(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            bottomNode = node;
            topNode = node;
        } else {
            node.setNext(topNode);
            topNode = node;
        }
        length++;
    }

    public Integer pop() {
        Integer value;
        if (topNode == bottomNode) {
            bottomNode = null;
        }
        if (topNode != null) {
            value = topNode.getValue();
            topNode = topNode.getNext();
            length--;
        } else {
            value = null;
        }
        return value;
    }

    public boolean isEmpty() {
        return bottomNode == null && topNode == null && length == 0;
    }

    public int getLength() {
        return length;
    }

    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("length -> " + stack.getLength());
        System.out.println("peek -> " + stack.peek());
        System.out.println("length -> " + stack.getLength());
        System.out.println("pop -> " + stack.pop());
        System.out.println("length -> " + stack.getLength());
        System.out.println("isEmpty -> " + stack.isEmpty());
        System.out.println("pop -> " + stack.pop());
        System.out.println("length -> " + stack.getLength());
        System.out.println("isEmpty -> " + stack.isEmpty());
        System.out.println("pop -> " + stack.pop());
        System.out.println("length -> " + stack.getLength());
        System.out.println("isEmpty -> " + stack.isEmpty());
        System.out.println("pop -> " + stack.pop());
        System.out.println("length -> " + stack.getLength());
        System.out.println("isEmpty -> " + stack.isEmpty());
        /*
        output should be:
        length -> 3
        peek -> 3
        length -> 3
        pop -> 3
        length -> 2
        isEmpty -> false
        pop -> 2
        length -> 1
        isEmpty -> false
        pop -> 1
        length -> 0
        isEmpty -> true
        pop -> null
        length -> 0
        isEmpty -> true
         */
    }

}
