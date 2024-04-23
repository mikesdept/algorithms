package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfsInorderTraversal(root, result);
        return result;
    }

    private void dfsInorderTraversal(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        dfsInorderTraversal(node.left, result);
        result.add(node.val);
        dfsInorderTraversal(node.right, result);
    }

    public static void main(String[] args) {
        BinaryTreeInorderTraversal94 binaryTreeInorderTraversal94 = new BinaryTreeInorderTraversal94();
        TreeNode treeNode1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        TreeNode treeNode2 = null;
        TreeNode treeNode3 = new TreeNode(3);
        System.out.println(binaryTreeInorderTraversal94.inorderTraversal(treeNode1)); // [1, 3, 2]
        System.out.println(binaryTreeInorderTraversal94.inorderTraversal(treeNode2)); // []
        System.out.println(binaryTreeInorderTraversal94.inorderTraversal(treeNode3)); // [1]
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
