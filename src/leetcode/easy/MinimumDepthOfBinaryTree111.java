package leetcode.easy;

public class MinimumDepthOfBinaryTree111 {

    public int minDepth(TreeNode root) {
        return getMinDepth(root);
    }

    private int getMinDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = getMinDepth(node.left);
        int right = getMinDepth(node.right);
        if (left == 0) {
            return right + 1;
        } else if (right == 0) {
            return left + 1;
        } else {
            return Math.min(left, right) + 1;
        }
    }

    public static void main(String[] args) {
        MinimumDepthOfBinaryTree111 minimumDepthOfBinaryTree111 = new MinimumDepthOfBinaryTree111();
        TreeNode node1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode node2 = new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6)))));
        System.out.println(minimumDepthOfBinaryTree111.minDepth(node1)); // 2
        System.out.println(minimumDepthOfBinaryTree111.minDepth(node2)); // 5
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
