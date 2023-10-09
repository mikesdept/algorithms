package datastructures.linkedlists;

public class MyLinkedList {

    // TODO: add length parameter
    // TODO: add reverse for Singly Linked List
    // TODO: separate somehow Singly Linked List and Doubly Linked List

    private Node head;
    private Node tail;

    public MyLinkedList(int value) {
        head = new Node(value);
        tail = head;
    }

    public void append(int value) {
        Node tailNew = new Node(value);
        tailNew.setPrev(tail);
        tail.setNext(tailNew);
        tail = tailNew;
    }

    public void prepend(int value) {
        Node headNew = new Node(value);
        headNew.setNext(head);
        head.setPrev(headNew);
        head = headNew;
    }

    public void insert(int index, int value) {
        if (index < 0) {
            return;
        }
        if (index == 0) {
            prepend(value);
            return;
        }
        Node prevNode = getPrevNodeOfIndex(index);
        if (prevNode == null) {
            return;
        }
        Node nextNode = prevNode.next;
        if (nextNode == null) {
            append(value);
            return;
        }
        Node newNode = new Node(value);
        newNode.setPrev(prevNode);
        newNode.setNext(nextNode);
        prevNode.setNext(newNode);
        nextNode.setPrev(newNode);
    }

    public void remove(int index) {
        if (index < 0) {
            return;
        }
        if (index == 0) {
            head = head.next;
            head.setPrev(null);
            return;
        }
        Node prevNode = getPrevNodeOfIndex(index);
        if (prevNode == null) {
            return;
        }
        Node deleteNode = prevNode.next;
        if (deleteNode != null) {
            Node nextNode = deleteNode.next;
            prevNode.setNext(nextNode);
            if (nextNode != null) {
                nextNode.setPrev(prevNode);
            } else {
                tail = prevNode;
            }
        }
    }

    public void reverse() {
        Node node = tail;
        head = node;
        while (node != null) {
            Node prevNode = node.prev;
            Node nextNode = node.next;
            node.setPrev(nextNode);
            node.setNext(prevNode);
            if (prevNode == null) {
                tail = node;
            }
            node = prevNode;
        }
    }

    public void printLinkedList() {
        System.out.println("Print Linked List from head to tail");
        Node node = head;
        while (node != null) {
            System.out.println("item -> " + node.value);
            node = node.next;
        }
    }

    public void printLinkedListViceVersa() {
        System.out.println("Print Linked List from tail to head");
        Node node = tail;
        while (node != null) {
            System.out.println("item -> " + node.value);
            node = node.prev;
        }
    }

    private Node getPrevNodeOfIndex(int index) {
        int currentIndex = 1;
        Node prevNode = head;
        while (currentIndex < index && prevNode != null) {
            prevNode = prevNode.next;
            currentIndex++;
        }
        return prevNode;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList(1);
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
        linkedList.printLinkedList();
        linkedList.printLinkedListViceVersa();
        linkedList.reverse();
        linkedList.printLinkedList();
        linkedList.printLinkedListViceVersa();
        // valid output for this example is:
        // 6 4 3 8 2 5 11
        // 11 5 2 8 3 4 6
        // 11 5 2 8 3 4 6
        // 6 4 3 8 2 5 11
    }

    public class Node {

        private Node next;
        private Node prev;
        private int value;

        public Node(int value) {
            this.value = value;
        }

        public void setNext(Node node) {
            this.next = node;
        }

        public void setPrev(Node node) {
            this.prev = node;
        }

    }

}
