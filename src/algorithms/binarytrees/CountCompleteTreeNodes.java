package algorithms.binarytrees;

public class CountCompleteTreeNodes {

    // notes
    /*
    level = 4
    possible count of nodes at the latest level = level * 2 = 8
    left = 0
    right = 7
    middle = 4
    root -> 0, 1, 2, 3, 4, 5, 6, 7
    8 / 2 -> 4 >= 4 -> right
    right -> 4, 5, 6, 7
    11 / 2 -> 4 >= 6 -> left
    left -> 4, 5
    9 / 2 -> 4 >= 5 -> left
    left -> 4
    left = 0, right = 3
     */

    //             1
    //         2        3
    //      4     5    6   7
    //     8 9   n n  n n n n
    // result -> 9
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode leftNode = root;
        int level = 0;
        while (leftNode != null) {
            level++;
            leftNode = leftNode.left;
        }
        int nodesAboveLastLevel = (int) (Math.round(Math.pow(2, level - 1)) - 1);

        int possibleNodesLastLevel = (int) (Math.round(Math.pow(2, level - 1)));
        int left = 0;
        int right = possibleNodesLastLevel - 1;
        int latestNodeIndexCandidate = 0;
        while (left <= right) {
            TreeNode searchNode = root;
            int indexToCheck = (left + right + 1) / 2;
            int leftSearch = 0;
            int rightSearch = possibleNodesLastLevel - 1;
            int currentLevel = 1;
            while (currentLevel < level) {
                int middle = (leftSearch + rightSearch + 1) / 2;
                if (indexToCheck >= middle) {
                    searchNode = searchNode.right;
                    leftSearch = middle;
                } else {
                    searchNode = searchNode.left;
                    rightSearch = middle;
                }
                currentLevel++;
            }
            if (searchNode != null) {
                latestNodeIndexCandidate = indexToCheck;
                left = indexToCheck + 1;
            } else {
                right = indexToCheck - 1;
            }
        }
        System.out.println(latestNodeIndexCandidate);

        int result = nodesAboveLastLevel + latestNodeIndexCandidate + 1;
        return result;
    }

    public static void main(String[] args) {
        CountCompleteTreeNodes countCompleteTreeNodes = new CountCompleteTreeNodes();
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(8), new TreeNode(9)), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        System.out.println(countCompleteTreeNodes.countNodes(treeNode));
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
