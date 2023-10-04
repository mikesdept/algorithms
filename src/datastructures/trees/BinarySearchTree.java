package datastructures.trees;

// TODO: implement remove function
// TODO: // TODO: write traverse function using recursion
public class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
        } else {
            Node bottomNode = root;
            while (true) {
                if (value < bottomNode.getValue()) {
                    Node left = bottomNode.getLeft();
                    if (left == null) {
                        bottomNode.setLeft(node);
                        break;
                    } else {
                        bottomNode = left;
                    }
                } else if (value > bottomNode.getValue()) {
                    Node right = bottomNode.getRight();
                    if (right == null) {
                        bottomNode.setRight(node);
                        break;
                    } else {
                        bottomNode = right;
                    }
                } else {
                    break;
                }
            }
        }
    }

    public Integer lookup(int value) {
        Node node = root;
        while (node != null && node.getValue() != value) {
            if (value < node.getValue()) {
                node = node.getLeft();
            } else if (value > node.getValue()) {
                node = node.getRight();
            }
        }
        if (node != null) {
            return node.getValue();
        } else {
            return null;
        }
    }

    public void remove(int value) {

    }

    public String toString() {
        return root.toString();
    }

    public static void main(String[] args) {
        //        9
        //     4     20
        //  1    6  15  170
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(9);
        tree.insert(4);
        tree.insert(6);
        tree.insert(20);
        tree.insert(170);
        tree.insert(15);
        tree.insert(1);

        System.out.println("lookup 9 -> " + tree.lookup(9));
        System.out.println("lookup 4 -> " + tree.lookup(4));
        System.out.println("lookup 6 -> " + tree.lookup(6));
        System.out.println("lookup 20 -> " + tree.lookup(20));
        System.out.println("lookup 170 -> " + tree.lookup(170));
        System.out.println("lookup 15 -> " + tree.lookup(15));
        System.out.println("lookup 1 -> " + tree.lookup(1));
        System.out.println("lookup 2 -> " + tree.lookup(2));
        System.out.println("lookup 200 -> " + tree.lookup(200));

        System.out.println("Tree -> " + tree);
    }

}
