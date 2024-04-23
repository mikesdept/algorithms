package leetcode.easy;

public class MaximumDepthOfBinaryTree104 {

    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftLength = dfs(node.left);
        int rightLength = dfs(node.right);
        int maxDepth = Math.max(leftLength, rightLength) + 1;
        return maxDepth;
    }

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree104 maximumDepthOfBinaryTree104 = new MaximumDepthOfBinaryTree104();
        TreeNode treeNode1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode treeNode2 = new TreeNode(1, null, new TreeNode(2));
        System.out.println(maximumDepthOfBinaryTree104.maxDepth(treeNode1)); // 3
        System.out.println(maximumDepthOfBinaryTree104.maxDepth(treeNode2)); // 2
    }

    private static class TreeNode {
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
