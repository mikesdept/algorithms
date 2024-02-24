package leetcode.medium;

public class SumOfNodesWithEvenValuedGrandparent1315 {

    private int leftDirection = -1;
    private int rightDirection = 1;

    public int sumEvenGrandparent(TreeNode root) {
        TreeNode grandParentNode = new TreeNode(1, new TreeNode(1, root, null), null);
        int[] lastDirections = new int[]{leftDirection, leftDirection};
        return sumDfs(root, grandParentNode, lastDirections);
    }

    private int sumDfs(TreeNode node, TreeNode grandParentNode, int[] lastDirections) {
        if (node == null) {
            return 0;
        } else {
            TreeNode leftRightGrandParentNode = lastDirections[0] == leftDirection ? grandParentNode.left : grandParentNode.right;

            int[] leftLastDirections = new int[]{lastDirections[1], leftDirection};
            TreeNode leftNode = node.left;

            int[] rightLastDirections = new int[]{lastDirections[1], rightDirection};
            TreeNode rightNode = node.right;

            int leftValue = sumDfs(leftNode, leftRightGrandParentNode, leftLastDirections);
            int rightValue = sumDfs(rightNode, leftRightGrandParentNode, rightLastDirections);

            return leftValue + rightValue + (grandParentNode.val % 2 == 0 ? node.val : 0);
        }
    }

    public static void main(String[] args) {
        SumOfNodesWithEvenValuedGrandparent1315 sumOfNodesWithEvenValuedGrandparent1315 = new SumOfNodesWithEvenValuedGrandparent1315();
        TreeNode node1 = new TreeNode(6, new TreeNode(7, new TreeNode(2, new TreeNode(9), null), new TreeNode(7, new TreeNode(1), new TreeNode(4))), new TreeNode(8, new TreeNode(1), new TreeNode(3, null, new TreeNode(5))));
        TreeNode node2 = new TreeNode(1);
        System.out.println(sumOfNodesWithEvenValuedGrandparent1315.sumEvenGrandparent(node1)); // 18
        System.out.println(sumOfNodesWithEvenValuedGrandparent1315.sumEvenGrandparent(node2)); // 0
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
