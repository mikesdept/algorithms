package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        LinkedList<Integer> levelList = new LinkedList<>();
        int levelSize = 1;
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            levelSize--;
            TreeNode node = queue.poll();
            if (leftToRight) {
                levelList.addLast(node.val);
            } else {
                levelList.addFirst(node.val);
            }

            TreeNode left = node.left;
            TreeNode right = node.right;
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }

            if (levelSize == 0) {
                levelSize = queue.size();
                leftToRight = !leftToRight;
                result.add(levelList);
                levelList = new LinkedList<>();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal103 binaryTreeZigzagLevelOrderTraversal103 = new BinaryTreeZigzagLevelOrderTraversal103();
        TreeNode treeNode1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = null;
        System.out.println(binaryTreeZigzagLevelOrderTraversal103.zigzagLevelOrder(treeNode1)); // [[3],[20,9],[15,7]]
        System.out.println(binaryTreeZigzagLevelOrderTraversal103.zigzagLevelOrder(treeNode2)); // [[1]]
        System.out.println(binaryTreeZigzagLevelOrderTraversal103.zigzagLevelOrder(treeNode3)); // []
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
