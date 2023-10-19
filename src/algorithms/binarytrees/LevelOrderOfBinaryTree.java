package algorithms.binarytrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class LevelOrderOfBinaryTree {

    //    1
    //  2   3
    //4   5
    //   6 7
    // [[1], [2, 3], [4, 5], [6, 7]]
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();
        while (queue.size() > 0) {
            int levelSize = queue.size();
            int levelSizeCounter = 0;
            List<Integer> innerResult = new ArrayList<>();
            while (levelSizeCounter < levelSize) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                innerResult.add(node.val);
                levelSizeCounter++;
            }
            result.add(innerResult);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(6), new TreeNode(7))), new TreeNode(3));
        LevelOrderOfBinaryTree levelOrderOfBinaryTree = new LevelOrderOfBinaryTree();
        System.out.println(levelOrderOfBinaryTree.levelOrder(treeNode));
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
