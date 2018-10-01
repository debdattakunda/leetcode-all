package main.java.problem_257;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: Debdatta Kunda
 * @problem-statement:
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
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

    List<String> list = new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        helper(root, "");
        return list;
    }

    private void helper(TreeNode root, String path) {

        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            path = path + root.val;
            list.add(path);
            return;
        }
        path = path + root.val + "->";
        helper(root.left, path);
        helper(root.right, path);
    }
}
