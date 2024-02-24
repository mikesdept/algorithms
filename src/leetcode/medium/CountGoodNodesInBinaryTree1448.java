package leetcode.medium;

public class CountGoodNodesInBinaryTree1448 {

    public int goodNodes(TreeNode root) {
        return getGoodNodes(root, Integer.MIN_VALUE);
    }

    private int getGoodNodes(TreeNode node, int previousMax) {
        if (node == null) {
            return 0;
        } else {
            int leftGoodNodes = getGoodNodes(node.left, Math.max(previousMax, node.val));
            int rightGoodNodes = getGoodNodes(node.right, Math.max(previousMax, node.val));
            int result = leftGoodNodes + rightGoodNodes + (previousMax <= node.val ? 1 : 0);
            return result;
        }
    }

    public static void main(String[] args) {
        CountGoodNodesInBinaryTree1448 countGoodNodesInBinaryTree1448 = new CountGoodNodesInBinaryTree1448();
        TreeNode node1 = new TreeNode(3, new TreeNode(1, new TreeNode(3), null), new TreeNode(4, new TreeNode(1), new TreeNode(5)));
        TreeNode node2 = new TreeNode(3, new TreeNode(3, new TreeNode(4), new TreeNode(2)), null);
        TreeNode node3 = new TreeNode(1);
        System.out.println(countGoodNodesInBinaryTree1448.goodNodes(node1)); // 4
        System.out.println(countGoodNodesInBinaryTree1448.goodNodes(node2)); // 3
        System.out.println(countGoodNodesInBinaryTree1448.goodNodes(node3)); // 1
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
