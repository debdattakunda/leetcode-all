package main.java.problem_653;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: Debdatta Kunda
 * @problem-statement:
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
 *
 * Example 1:
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * Output: True
 * Example 2:
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * Output: False
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

    public boolean findTarget(TreeNode root, int k) {

        List<Integer> inorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            TreeNode currNode = stack.pop();
            inorder.add(currNode.val);
            if (currNode.right != null) {
                currNode = currNode.right;
                while (currNode != null) {
                    stack.push(currNode);
                    currNode = currNode.left;
                }
            }
        }
        return helper(inorder, k);
    }

    private boolean helper(List<Integer> list, int target) {

        int low = 0;
        int high = list.size() - 1;
        while (low < high) {
            int temp = list.get(low) + list.get(high);
            if (temp == target) {
                return true;
            } else if (target < temp) {
                high--;
            } else {
                low++;
            }
        }
        return false;
    }
}
