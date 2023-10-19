package algorithms.binarytrees;

public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        return getDepth(root, 0);
    }

    //    1
    //  2   3
    //4   5
    //   6 7
    private int getDepth(TreeNode node, int intermediateCounter) {
        if (node == null) {
            return intermediateCounter;
        }
        intermediateCounter++;
        int leftDepth = getDepth(node.left, intermediateCounter);
        int rightDepth = getDepth(node.right, intermediateCounter);
        return Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(6), new TreeNode(7))), new TreeNode(3));
        MaximumDepthOfBinaryTree maximumDepthOfBinaryTree = new MaximumDepthOfBinaryTree();
        System.out.println(maximumDepthOfBinaryTree.maxDepth(treeNode)); // 4
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
