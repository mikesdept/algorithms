package leetcode.medium;

import java.util.Map;
import java.util.TreeMap;

public class LowestCommonAncestorOfDeepestLeaves1123 {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        TreeMap<Integer, TreeNode> map = new TreeMap<>();
        dfs(root, map, 1);
        return !map.isEmpty() ? map.get(map.lastKey()) : root;
    }

    private int dfs(TreeNode node, Map<Integer, TreeNode> map, int level) {
        if (node == null) {
            return 0;
        } else {
            int leftCount = dfs(node.left, map, level + 1);
            int rightCount = dfs(node.right, map, level + 1);

            if (leftCount == 1 && rightCount == 1) {
                map.put(level, node);
            } else if (leftCount == 1 && rightCount == 0) {
                map.put(level + 1, node.left);
            } else if (leftCount == 0 && rightCount == 1) {
                map.put(level + 1, node.right);
            }

            return Math.max(leftCount, rightCount) + 1;
        }
    }

    public static void main(String[] args) {
        LowestCommonAncestorOfDeepestLeaves1123 lowestCommonAncestorOfDeepestLeaves1123 = new LowestCommonAncestorOfDeepestLeaves1123();
        TreeNode node1 = new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))), new TreeNode(1, new TreeNode(0), new TreeNode(8)));
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(0, new TreeNode(1, null, new TreeNode(2)), new TreeNode(3));
        System.out.println(lowestCommonAncestorOfDeepestLeaves1123.lcaDeepestLeaves(node1).val); // 2
        System.out.println(lowestCommonAncestorOfDeepestLeaves1123.lcaDeepestLeaves(node2).val); // 1
        System.out.println(lowestCommonAncestorOfDeepestLeaves1123.lcaDeepestLeaves(node3).val); // 2
    }

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

}
