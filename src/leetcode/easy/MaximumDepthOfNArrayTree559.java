package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class MaximumDepthOfNArrayTree559 {

    public int maxDepth(Node root) {
        return getMaxDepth(root);
    }

    private int getMaxDepth(Node node) {
        if (node == null) {
            return 0;
        } else {
            int maxDepth = 0;
            if (node.children != null) {
                for (Node child : node.children) {
                    int depth = getMaxDepth(child);
                    maxDepth = Math.max(maxDepth, depth);
                }
            }
            return maxDepth + 1;
        }
    }

    public static void main(String[] args) {
        MaximumDepthOfNArrayTree559 maximumDepthOfNArrayTree559 = new MaximumDepthOfNArrayTree559();

        List<Node> node3Children = new ArrayList<>();
        node3Children.add(new Node(5));
        node3Children.add(new Node(6));

        List<Node> node1Children = new ArrayList<>();
        node1Children.add(new Node(3, node3Children));
        node1Children.add(new Node(2));
        node1Children.add(new Node(4));

        Node node1 = new Node(1, node1Children);
        System.out.println(maximumDepthOfNArrayTree559.maxDepth(node1)); // 3
    }

    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
