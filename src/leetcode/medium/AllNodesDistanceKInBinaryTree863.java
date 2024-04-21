package leetcode.medium;

import java.util.*;

public class AllNodesDistanceKInBinaryTree863 {

    private Map<Integer, TreeNode> map = new HashMap<>();
    private List<Integer> result = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfs(root, null);
        bfs(target, k);
        return result;
    }

    private void dfs(TreeNode node, TreeNode parent) {
        if (node == null) {
            return;
        }
        map.put(node.val, parent);
        dfs(node.left, node);
        dfs(node.right, node);
    }

    private void bfs(TreeNode target, int k) {
        Queue<Pair> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(new Pair(target, 0));
        visited.add(target.val);
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int level = pair.level;
            if (level == k) {
                result.add(node.val);
            } else if (level < k) {
                if (node.left != null && !visited.contains(node.left.val)) {
                    queue.add(new Pair(node.left, level + 1));
                    visited.add(node.left.val);
                }
                if (node.right != null && !visited.contains(node.right.val)) {
                    queue.add(new Pair(node.right, level + 1));
                    visited.add(node.right.val);
                }
                if (map.get(node.val) != null && !visited.contains(map.get(node.val).val)) {
                    queue.add(new Pair(map.get(node.val), level + 1));
                    visited.add(map.get(node.val).val);
                }
            }
        }
    }

    private class Pair {
        TreeNode node;
        int level;

        public Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public static void main(String[] args) {
        AllNodesDistanceKInBinaryTree863 allNodesDistanceKInBinaryTree863 = new AllNodesDistanceKInBinaryTree863();
        TreeNode targetNode = new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4)));
        TreeNode treeNode = new TreeNode(3, targetNode, new TreeNode(1, new TreeNode(0), new TreeNode(8)));
        System.out.println(allNodesDistanceKInBinaryTree863.distanceK(treeNode, targetNode, 2)); // [7, 4, 1]
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int x, TreeNode left, TreeNode right) {
            this.val = x;
            this.left = left;
            this.right = right;
        }
    }

}
