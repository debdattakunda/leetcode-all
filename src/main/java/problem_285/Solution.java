package main.java.problem_285;

import java.util.ArrayList;
import java.util.List;

/**
 * @problem-statement : Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 *
 * Note: If the given node has no in-order successor in the tree, return null.
 *
 * Example 1:
 *
 * Input: root = [2,1,3], p = 1
 *
 *   2
 *  / \
 * 1   3
 *
 * Output: 2
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], p = 6
 *
 *       5
 *      / \
 *     3   6
 *    / \
 *   2   4
 *  /
 * 1
 *
 * Output: null
 */

class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<TreeNode> list = new ArrayList<>();
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        int index = 0;
        inorder(root);
        for (TreeNode node : list) {
            if (node.val == p.val) {
                break;
            }
            index++;
        }
        return index + 1 >= list.size() ? null : list.get(index + 1);
    }

    private List<TreeNode> inorder(TreeNode root) {

        if (root == null) {
            return list;
        }
        inorder(root.left);
        list.add(root);
        inorder(root.right);
        return list;
    }
}