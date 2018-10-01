package main.java.problem_101;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */

public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    boolean result = true;
    public boolean isSymmetric(TreeNode root) {
        if(root != null) {
            helper(root.left, root.right);
        }
        return result;
    }
    private void helper(TreeNode leftNode, TreeNode rightNode) {

        if(leftNode == null && rightNode == null) {
            return;
        }
        if(leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
            result = false;
            return;
        }
        helper(leftNode.left, rightNode.right);
        helper(leftNode.right, rightNode.left);
    }
}