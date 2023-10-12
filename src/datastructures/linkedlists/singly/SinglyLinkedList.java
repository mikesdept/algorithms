package datastructures.linkedlists.singly;

public class SinglyLinkedList {

    public Node headNode;
    public Node tailNode;
    public int length;

    public SinglyLinkedList(int rootValue) {
        init(rootValue);
    }

    public void append(int value) {
        if (length == 0) {
            init(value);
        } else {
            Node node = new Node(value);
            tailNode.setNext(node);
            tailNode = node;
            length++;
        }
    }

    public void prepend(int value) {
        if (length == 0) {
            init(value);
        } else {
            Node node = new Node(value);
            node.setNext(headNode);
            headNode = node;
            length++;
        }
    }

    public void insert(int position, int value) {
        if (position < 0 || position > length) {
            return;
        } else if (position == 0) {
            prepend(value);
        } else if (position == length) {
            append(value);
        } else {
            Node previousNode = headNode;
            for (int i = 1; i < position; i++) {
                previousNode = previousNode.getNext();
            }
            Node nextNode = previousNode.getNext();
            Node newNode = new Node(value);
            previousNode.setNext(newNode);
            newNode.setNext(nextNode);
            length++;
        }
    }

    public void remove(int position) {
        if (position < 0 || position >= length) {
            return;
        } else if (position == 0) {
            headNode = headNode.getNext();
            length--;
        } else {
            Node previousNode = headNode;
            for (int i = 1; i < position; i++) {
                previousNode = previousNode.getNext();
            }
            Node deleteNode = previousNode.getNext();
            Node nextNode = deleteNode.getNext();
            previousNode.setNext(nextNode);
            if (nextNode == null) {
                tailNode = previousNode;
            }
            length--;
        }
    }

    public void reverse() {
        Node previous = null;
        Node current = headNode;
        tailNode = current;
        while (current != null) {
            Node next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        headNode = previous;
    }

    public void printLinkedList() {
        System.out.println("Print Linked List from head to tail");
        Node node = headNode;
        while (node != null) {
            System.out.println(node.getValue());
            node = node.getNext();
        }
    }

    private void init(int value) {
        headNode = new Node(value);
        tailNode = headNode;
        length = 1;
    }

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList(1);
        linkedList.append(2);
        linkedList.prepend(3);
        linkedList.prepend(4);
        linkedList.append(5);
        linkedList.prepend(6);
        linkedList.insert(3, 8);
        linkedList.insert(-1, 123);
        linkedList.insert(45, 321);
        linkedList.insert(0, 9);
        linkedList.insert(8, 10);
        linkedList.insert(8, 11);
        linkedList.remove(5);
        linkedList.remove(-1);
        linkedList.remove(22);
        linkedList.remove(8);
        linkedList.remove(0);
        linkedList.remove(7);
        linkedList.printLinkedList(); // 6 4 3 8 2 5 11
        linkedList.reverse();
        linkedList.printLinkedList(); // 11 5 2 8 3 4 6
    }

}
