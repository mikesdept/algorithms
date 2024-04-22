package leetcode.medium;

public class MaximumDifferenceBetweenNodeAndAncestor1026 {

    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode node, int min, int max) {
        if (node == null) {
            return max - min;
        }
        min = Math.min(min, node.val);
        max = Math.max(max, node.val);
        int leftDifference = dfs(node.left, min, max);
        int rightDifference = dfs(node.right, min, max);
        return Math.max(leftDifference, rightDifference);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8, new TreeNode(3, new TreeNode(1), new TreeNode(6, new TreeNode(4), new TreeNode(7))), new TreeNode(10, null, new TreeNode(14, new TreeNode(13), null)));
        TreeNode node2 = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(0, new TreeNode(3), null)));
        MaximumDifferenceBetweenNodeAndAncestor1026 maximumDifferenceBetweenNodeAndAncestor1026 = new MaximumDifferenceBetweenNodeAndAncestor1026();
        System.out.println(maximumDifferenceBetweenNodeAndAncestor1026.maxAncestorDiff(node1)); // 7
        System.out.println(maximumDifferenceBetweenNodeAndAncestor1026.maxAncestorDiff(node2)); // 3
        System.out.println();
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
