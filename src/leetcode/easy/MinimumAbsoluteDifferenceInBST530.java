package leetcode.easy;

public class MinimumAbsoluteDifferenceInBST530 {

    private int minDifference = Integer.MAX_VALUE;
    private TreeNode previousNode;

    public int getMinimumDifference(TreeNode root) {
        minDifference = Integer.MAX_VALUE;
        previousNode = null;
        calculate(root);
        return minDifference;
    }

    private void calculate(TreeNode node) {
        if (node == null) {
            return;
        }
        calculate(node.left);
        if (previousNode != null) {
            minDifference = Math.min(minDifference, node.val - previousNode.val);
        }
        previousNode = node;
        calculate(node.right);
    }

    public static void main(String[] args) {
        MinimumAbsoluteDifferenceInBST530 minimumAbsoluteDifferenceInBST530 = new MinimumAbsoluteDifferenceInBST530();
        TreeNode treeNode1 = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6));
        TreeNode treeNode2 = new TreeNode(1, new TreeNode(0), new TreeNode(48, new TreeNode(12), new TreeNode(49)));
        System.out.println(minimumAbsoluteDifferenceInBST530.getMinimumDifference(treeNode1)); // 1
        System.out.println(minimumAbsoluteDifferenceInBST530.getMinimumDifference(treeNode2)); // 1
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
