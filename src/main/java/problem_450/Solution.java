package main.java.problem_450;

/**
 * @problem-statement : Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 *
 * Basically, the deletion can be divided into two stages:
 *
 * Search for a node to remove.
 * If the node is found, delete the node.
 * Note: Time complexity should be O(height of tree).
 *
 * Example:
 *
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Given key to delete is 3. So we find the node with value 3 and delete it.
 *
 * One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
 *
 *     5
 *    / \
 *   4   6
 *  /     \
 * 2       7
 *
 * Another valid answer is [5,2,6,null,4,null,7].
 *
 *     5
 *    / \
 *   2   6
 *    \   \
 *     4   7
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

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        if (key == root.val) {
            TreeNode temp = root.left;
            root = root.right;
            if (root == null && temp == null) {
                return null;
            } else if (root == null && temp != null) {
                root = temp;
            } else {
                root.left = buildLeftTree(root.left, temp);
            }
        }
        return root;
    }

    private TreeNode buildLeftTree(TreeNode root, TreeNode left) {
        if (root == null) {
            root = left;
            return root;
        }
        root.left = buildLeftTree(root.left, left);
        return root;
    }
}
