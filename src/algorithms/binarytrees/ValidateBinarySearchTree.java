package algorithms.binarytrees;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode node) {
        if (node == null) {
            return true;
        }
        return isValidBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, int min, int max) {
        if (node.val <= min || node.val >= max) {
            return false;
        }
        if (node.left != null) {
            if (!isValidBST(node.left, min, node.val)) {
                return false;
            }
        }
        if (node.right != null) {
            if (!isValidBST(node.right, node.val, max)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        TreeNode validTreeNode = new TreeNode(10, new TreeNode(5, new TreeNode(3), new TreeNode(8)), new TreeNode(18, new TreeNode(12), new TreeNode(25)));
        TreeNode invalidTreeNode = new TreeNode(10, new TreeNode(5, new TreeNode(3), new TreeNode(11)), new TreeNode(18, new TreeNode(12), new TreeNode(25)));
        System.out.println("valid tree node -> " + validateBinarySearchTree.isValidBST(validTreeNode));
        System.out.println("invalid tree node -> " + validateBinarySearchTree.isValidBST(invalidTreeNode));
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
