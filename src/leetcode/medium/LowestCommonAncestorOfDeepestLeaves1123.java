package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorOfDeepestLeaves1123 {

    private int leftDirection = -1;
    private int rightDirection = 1;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int maxLevel = getMaxLevel(root);
        int[] directions = new int[maxLevel];

        List<int[]> leavesPath = new ArrayList<>();
        dfs(root, 1, directions, leavesPath);

        int maxDirectionsSize = 0;
        for (int[] leavePath : leavesPath) {
            for (int i = 0; i < leavePath.length; i++) {
                maxDirectionsSize = Math.max(maxDirectionsSize, leavePath.length);
            }
        }

        List<int[]> maxLeavesPath = new ArrayList<>();
        for (int[] leavePath : leavesPath) {
            if (leavePath.length == maxDirectionsSize) {
                maxLeavesPath.add(leavePath);
            }
        }

        if (maxLeavesPath.size() == 0) {
            return root;
        } else if (maxLeavesPath.size() == 1) {
            return getNodeByPath(root, maxLeavesPath.get(0), maxLeavesPath.get(0).length - 1);
        } else {
            int i = 0;
            while (i < maxDirectionsSize) {
                boolean elementsEqual = true;
                int element = maxLeavesPath.get(0)[i];
                for (int j = 0; j < maxLeavesPath.size(); j++) {
                    if (maxLeavesPath.get(j)[i] != element) {
                        elementsEqual = false;
                        break;
                    }
                }
                if (!elementsEqual) {
                    break;
                }
                i++;
            }
            int indexOfCommonPath = i - 1;
            if (indexOfCommonPath == -1) {
                return root;
            } else {
                return getNodeByPath(root, maxLeavesPath.get(0), indexOfCommonPath);
            }
        }
    }

    private int getMaxLevel(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int leftCount = getMaxLevel(node.left);
            int rightCount = getMaxLevel(node.right);
            return Math.max(leftCount, rightCount) + 1;
        }
    }

    private int dfs(TreeNode node, int level, int[] directions, List<int[]> leavesPath) {
        if (node == null) {
            return 0;
        } else {
            directions[level - 1] = leftDirection;
            int leftCount = dfs(node.left, level + 1, directions, leavesPath);
            directions[level - 1] = rightDirection;
            int rightCount = dfs(node.right, level + 1, directions, leavesPath);

            if (leftCount == 0 && rightCount == 0) {
                int[] directionsToSave = new int[level - 1];
                System.arraycopy(directions, 0, directionsToSave, 0, level - 1);
                leavesPath.add(directionsToSave);
            }
            return Math.max(leftCount, rightCount) + 1;
        }
    }

    private TreeNode getNodeByPath(TreeNode node, int[] directions, int finalIndex) {
        for (int pathIndex = 0; pathIndex <= finalIndex; pathIndex++) {
            if (directions[pathIndex] == leftDirection) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        LowestCommonAncestorOfDeepestLeaves1123 lowestCommonAncestorOfDeepestLeaves1123 = new LowestCommonAncestorOfDeepestLeaves1123();
        TreeNode node1 = new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))), new TreeNode(1, new TreeNode(0), new TreeNode(8)));
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(0, new TreeNode(1, null, new TreeNode(2)), new TreeNode(3));
        TreeNode node4 = new TreeNode(1, new TreeNode(2, new TreeNode(3, null, new TreeNode(6)), new TreeNode(4, null, new TreeNode(5))), null);
        System.out.println(lowestCommonAncestorOfDeepestLeaves1123.lcaDeepestLeaves(node1).val); // 2
        System.out.println(lowestCommonAncestorOfDeepestLeaves1123.lcaDeepestLeaves(node2).val); // 1
        System.out.println(lowestCommonAncestorOfDeepestLeaves1123.lcaDeepestLeaves(node3).val); // 2
        System.out.println(lowestCommonAncestorOfDeepestLeaves1123.lcaDeepestLeaves(node4).val); // 2
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
