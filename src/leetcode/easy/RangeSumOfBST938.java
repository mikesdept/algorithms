package leetcode.easy;

public class RangeSumOfBST938 {

    public int rangeSumBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }

    private int dfs(TreeNode node, int low, int high) {
        if (node == null) {
            return 0;
        }
        int leftSum = dfs(node.left, low, high);
        int rightSum = dfs(node.right, low, high);
        int currentValue = node.val >= low && node.val <= high ? node.val : 0;
        return leftSum + rightSum + currentValue;
    }

    public static void main(String[] args) {
        RangeSumOfBST938 rangeSumOfBST938 = new RangeSumOfBST938();
        TreeNode treeNode1 = new TreeNode(10, new TreeNode(5, new TreeNode(3), new TreeNode(7)), new TreeNode(15, null, new TreeNode(18)));
        TreeNode treeNode2 = new TreeNode(10, new TreeNode(5, new TreeNode(3, new TreeNode(1), null), new TreeNode(7, new TreeNode(6), null)), new TreeNode(15, new TreeNode(13), new TreeNode(18)));
        System.out.println(rangeSumOfBST938.rangeSumBST(treeNode1, 7, 15)); // 32
        System.out.println(rangeSumOfBST938.rangeSumBST(treeNode2, 6, 10)); // 23
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
