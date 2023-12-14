package algorithms.binarytrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class RightSideViewBinaryTree {

    //             1
    //         2        3
    //      4     5    6
    //        7
    //       8
    // result -> 1, 3, 6, 7, 8
    public List<Integer> rightSideViewBFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        TreeNode latestLevelNode = null;
        while (queue.size() > 0) {
            int levelLength = queue.size();
            int currentItemIndexInLevel = 0;
            while (currentItemIndexInLevel < levelLength) {
                latestLevelNode = queue.poll();
                if (latestLevelNode.left != null) {
                    queue.add(latestLevelNode.left);
                }
                if (latestLevelNode.right != null) {
                    queue.add(latestLevelNode.right);
                }
                currentItemIndexInLevel++;
            }
            result.add(latestLevelNode.val);
        }
        return result;
    }

    //             1
    //         2        3
    //      4     5    6
    //        7
    //       8
    // result -> 1, 3, 6, 7, 8
    public List<Integer> rightSideViewDFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        } else {
            rightSideViewDFS1(root, result, 0);
        }
        return result;
    }

    public void rightSideViewDFS1(TreeNode node, List<Integer> result, int currentLevel) {
        currentLevel++;
        if (result.size() < currentLevel) {
            result.add(node.val);
        }
        if (node.right != null) {
            rightSideViewDFS1(node.right, result, currentLevel);
        }
        if (node.left != null) {
            rightSideViewDFS1(node.left, result, currentLevel);
        }
    }

    public static void main(String[] args) {
        RightSideViewBinaryTree rightSideViewBinaryTree = new RightSideViewBinaryTree();
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, new TreeNode(7, new TreeNode(8), null)), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));
        System.out.println("BFS implementation");
        System.out.println(rightSideViewBinaryTree.rightSideViewBFS(treeNode)); // [1, 3, 6, 7, 8]
        System.out.println(rightSideViewBinaryTree.rightSideViewBFS(new TreeNode(1))); // [1]
        System.out.println(rightSideViewBinaryTree.rightSideViewBFS(null)); // []
        System.out.println("DFS implementation");
        System.out.println(rightSideViewBinaryTree.rightSideViewDFS(treeNode)); // [1, 3, 6, 7, 8]
        System.out.println(rightSideViewBinaryTree.rightSideViewDFS(new TreeNode(1))); // [1]
        System.out.println(rightSideViewBinaryTree.rightSideViewDFS(null)); // []
    }

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

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
