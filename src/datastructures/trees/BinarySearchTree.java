package datastructures.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

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

    public List<Integer> breadthFirstSearch() {
        Queue<Node> queue = new LinkedBlockingQueue<>();
        List<Integer> bfsPresentation = new ArrayList<>();
        if (root == null) {
            return bfsPresentation;
        }
        queue.add(root);
        while (queue.size() > 0) {
            Node node = queue.poll();
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
            bfsPresentation.add(node.getValue());
        }
        return bfsPresentation;
    }

    public List<Integer> breadthFirstSearchRecursive(Queue<Node> queue, List<Integer> bfsPresentation) {
        if (queue.size() == 0) {
            return bfsPresentation;
        }
        Node node = queue.poll();
        bfsPresentation.add(node.getValue());
        if (node.getLeft() != null) {
            queue.add(node.getLeft());
        }
        if (node.getRight() != null) {
            queue.add(node.getRight());
        }
        return breadthFirstSearchRecursive(queue, bfsPresentation);
    }

    public List<Integer> depthFirstSearchInOrder(Node node, List<Integer> dfsPresentation) {
        if (node.getLeft() != null) {
            depthFirstSearchInOrder(node.getLeft(), dfsPresentation);
        }
        dfsPresentation.add(node.getValue());
        if (node.getRight() != null) {
            depthFirstSearchInOrder(node.getRight(), dfsPresentation);
        }
        return dfsPresentation;
    }

    public List<Integer> depthFirstSearchPreOrder(Node node, List<Integer> dfsPresentation) {
        dfsPresentation.add(node.getValue());
        if (node.getLeft() != null) {
            depthFirstSearchPreOrder(node.getLeft(), dfsPresentation);
        }
        if (node.getRight() != null) {
            depthFirstSearchPreOrder(node.getRight(), dfsPresentation);
        }
        return dfsPresentation;
    }

    public List<Integer> depthFirstSearchPostOrder(Node node, List<Integer> dfsPresentation) {
        if (node.getLeft() != null) {
            depthFirstSearchPostOrder(node.getLeft(), dfsPresentation);
        }
        if (node.getRight() != null) {
            depthFirstSearchPostOrder(node.getRight(), dfsPresentation);
        }
        dfsPresentation.add(node.getValue());
        return dfsPresentation;
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
        System.out.println("BFS presentation -> " + tree.breadthFirstSearch());
        Queue<Node> queue = new LinkedBlockingQueue<>();
        queue.add(tree.root);
        System.out.println("BFS presentation recursive -> " + tree.breadthFirstSearchRecursive(queue, new ArrayList<>()));
        System.out.println("DFS Inorder -> " + tree.depthFirstSearchInOrder(tree.root, new ArrayList<>()));
        System.out.println("DFS Preorder -> " + tree.depthFirstSearchPreOrder(tree.root, new ArrayList<>()));
        System.out.println("DFS Postorder -> " + tree.depthFirstSearchPostOrder(tree.root, new ArrayList<>()));
    }

}
