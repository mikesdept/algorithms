package leetcode.easy;

public class DiameterOfBinaryTree543 {

    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        diameter(root);
        return diameter;
    }

    private int diameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = diameter(root.left);
        int right = diameter(root.right);
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree543 diameterOfBinaryTree543 = new DiameterOfBinaryTree543();
        TreeNode treeNode1 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        TreeNode treeNode2 = new TreeNode(1, new TreeNode(2), null);
        System.out.println(diameterOfBinaryTree543.diameterOfBinaryTree(treeNode1)); // 3
        System.out.println(diameterOfBinaryTree543.diameterOfBinaryTree(treeNode2)); // 1
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
