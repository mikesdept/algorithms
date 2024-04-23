package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list, 0);
        return list;
    }

    private void dfs(TreeNode node, List<Integer> list, int currentLevel) {
        if (node != null) {
            currentLevel++;
            if (list.size() < currentLevel) {
                list.add(node.val);
            }
            dfs(node.right, list, currentLevel);
            dfs(node.left, list, currentLevel);
        }
    }

    public static void main(String[] args) {
        BinaryTreeRightSideView199 binaryTreeRightSideView199 = new BinaryTreeRightSideView199();
        TreeNode treeNode1 = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)));
        TreeNode treeNode2 = new TreeNode(1, null, new TreeNode(3));
        TreeNode treeNode3 = null;
        System.out.println(binaryTreeRightSideView199.rightSideView(treeNode1)); // [1, 3, 4]
        System.out.println(binaryTreeRightSideView199.rightSideView(treeNode2)); // [1, 3]
        System.out.println(binaryTreeRightSideView199.rightSideView(treeNode3)); // []
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
