package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class FindLargestValueInEachTreeRow515 {

    public List<Integer> largestValues(TreeNode root) {
        return bfs(root);
    }

    private List<Integer> bfs(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        if (node != null) {
            Queue<TreeNode> queue = new LinkedBlockingQueue<>();
            queue.add(node);
            int nodesLeftOfCurrentLevel = 1;
            int currentLevelMaxNode = Integer.MIN_VALUE;
            while (!queue.isEmpty()) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
                currentLevelMaxNode = Math.max(currentLevelMaxNode, currentNode.val);
                nodesLeftOfCurrentLevel--;
                if (nodesLeftOfCurrentLevel == 0) {
                    result.add(currentLevelMaxNode);
                    nodesLeftOfCurrentLevel = queue.size();
                    currentLevelMaxNode = Integer.MIN_VALUE;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindLargestValueInEachTreeRow515 findLargestValueInEachTreeRow515 = new FindLargestValueInEachTreeRow515();
        TreeNode node1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)), new TreeNode(2, null, new TreeNode(9)));
        TreeNode node2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(findLargestValueInEachTreeRow515.largestValues(node1)); // [1, 3, 9]
        System.out.println(findLargestValueInEachTreeRow515.largestValues(node2)); // [1, 3]
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
