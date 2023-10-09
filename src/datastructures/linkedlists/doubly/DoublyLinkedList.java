package datastructures.linkedlists.doubly;

public class DoublyLinkedList {

    public Node headNode;
    public Node tailNode;
    public int length;

    public DoublyLinkedList(int value) {
        init(value);
    }

    public void append(int value) {
        if (length == 0) {
            init(value);
        } else {
            Node node = new Node(value);
            node.setPreviousNode(tailNode);
            tailNode.setNextNode(node);
            tailNode = node;
            length++;
        }
    }

    public void prepend(int value) {
        if (length == 0) {
            init(value);
        } else {
            Node node = new Node(value);
            headNode.setPreviousNode(node);
            node.setNextNode(headNode);
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
            Node newNode = new Node(value);
            Node previousNode = headNode;
            for (int i = 1; i < position; i++) {
                previousNode = previousNode.getNextNode();
            }
            Node nextNode = previousNode.getNextNode();
            newNode.setPreviousNode(previousNode);
            newNode.setNextNode(nextNode);
            previousNode.setNextNode(newNode);
            nextNode.setPreviousNode(newNode);
            length++;
        }
    }

    public void remove(int position) {
        if (position < 0 || position >= length) {
            return;
        } else if (position == 0) {
            Node firstNode = headNode.getNextNode();
            if (firstNode != null) {
                firstNode.setPreviousNode(null);
            }
            headNode = firstNode;
            length--;
        } else {
            Node previousNode = headNode;
            for (int i = 1; i < position; i++) {
                previousNode = previousNode.getNextNode();
            }
            Node deleteNode = previousNode.getNextNode();
            Node nextNode = deleteNode.getNextNode();
            previousNode.setNextNode(nextNode);
            if (nextNode != null) {
                nextNode.setPreviousNode(previousNode);
            } else {
                tailNode = previousNode;
            }
            length--;
        }
    }

    public void reverse() {
        Node node = headNode;
        while (node != null) {
            Node previousNode = node.getPreviousNode();
            Node nextNode = node.getNextNode();
            node.setNextNode(previousNode);
            node.setPreviousNode(nextNode);
            if (node.getPreviousNode() == null) {
                headNode = node;
            }
            if (node.getNextNode() == null) {
                tailNode = node;
            }
            node = node.getPreviousNode();
        }
    }

    public void printLinkedList() {
        System.out.println("Print Linked List from head to tail");
        Node node = headNode;
        while (node != null) {
            System.out.println(node.getValue());
            node = node.getNextNode();
        }
    }

    public void printLinkedListViceVersa() {
        System.out.println("Print Linked List from tail to head");
        Node node = tailNode;
        while (node != null) {
            System.out.println(node.getValue());
            node = node.getPreviousNode();
        }
    }

    private void init(int value) {
        headNode = new Node(value);
        tailNode = headNode;
        length = 1;
    }

    public static void main(String[] args) {
        DoublyLinkedList linkedList = new DoublyLinkedList(1);
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
        linkedList.printLinkedListViceVersa(); // 11 5 2 8 3 4 6
        linkedList.reverse();
        linkedList.printLinkedList(); // 11 5 2 8 3 4 6
        linkedList.printLinkedListViceVersa(); // 6 4 3 8 2 5 11
    }

}
