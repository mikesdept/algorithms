package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSum1302 {

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelSize = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }

            sum += node.val;
            levelSize--;
            if (levelSize == 0) {
                levelSize = queue.size();
                if (!queue.isEmpty()) {
                    sum = 0;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        DeepestLeavesSum1302 deepestLeavesSum1302 = new DeepestLeavesSum1302();
        TreeNode treeNode1 = new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(7), null), new TreeNode(5)), new TreeNode(3, null, new TreeNode(6, null, new TreeNode(8))));
        TreeNode treeNode2 = new TreeNode(6, new TreeNode(7, new TreeNode(2, new TreeNode(9), null), new TreeNode(7, new TreeNode(1), new TreeNode(4))), new TreeNode(8, new TreeNode(1), new TreeNode(3, null, new TreeNode(5))));
        System.out.println(deepestLeavesSum1302.deepestLeavesSum(treeNode1)); // 15
        System.out.println(deepestLeavesSum1302.deepestLeavesSum(treeNode2)); // 19
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
