package main.java.problem_113;

import java.util.ArrayList;
import java.util.List;

/**
 * @problem-statement : Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
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

    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root, sum, 0, new ArrayList<>());
        return result;
    }
    private void helper(TreeNode root, int sum, int level, List<Integer> list) {

        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null && root.val == sum) {
            list.add(root.val);
            result.add(new ArrayList<>(list));
            list.remove(level);
            return;
        }
        list.add(root.val);
        sum -= root.val;
        level++;
        helper(root.left, sum, level, list);
        helper(root.right, sum, level, list);
        list.remove(level-1);
        return;
    }
}
