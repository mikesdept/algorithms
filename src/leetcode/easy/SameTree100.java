package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(p, q));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (hasDifference(pair)) {
                return false;
            }
            if (pair.first != null && pair.second != null) {
                queue.add(new Pair(pair.first.left, pair.second.left));
                queue.add(new Pair(pair.first.right, pair.second.right));
            }
        }
        return true;
    }

    private boolean hasDifference(Pair pair) {
        return (pair.first == null && pair.second != null)
                || (pair.first != null && pair.second == null)
                || (pair.first != null && pair.second != null && pair.first.val != pair.second.val);
    }

    private class Pair {
        TreeNode first;
        TreeNode second;

        public Pair(TreeNode first, TreeNode second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        SameTree100 sameTree100 = new SameTree100();

        TreeNode treeNodeP1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode treeNodeQ1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        TreeNode treeNodeP2 = new TreeNode(1, new TreeNode(2), null);
        TreeNode treeNodeQ2 = new TreeNode(1, null, new TreeNode(2));

        TreeNode treeNodeP3 = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        TreeNode treeNodeQ3 = new TreeNode(1, new TreeNode(1), new TreeNode(2));

        System.out.println(sameTree100.isSameTree(treeNodeP1, treeNodeQ1)); // true
        System.out.println(sameTree100.isSameTree(treeNodeP2, treeNodeQ2)); // false
        System.out.println(sameTree100.isSameTree(treeNodeP3, treeNodeQ3)); // false
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
