package main.java.problem_654;

/**
 * @problem-statement : Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 *
 * The root is the maximum number in the array.
 * The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 * Construct the maximum tree by the given array and output the root node of this tree.
 *
 * Example 1:
 * Input: [3,2,1,6,0,5]
 * Output: return the tree root node representing the following tree:
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 * Note:
 * The size of the given array will be in the range [1,1000].
 */

class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if(start < 0 || start > nums.length-1 || end < 0 || end > nums.length-1) {
            return null;
        }
        int maxIndex = getMaxIndex(nums, start, end);
        int max = nums[maxIndex];
        TreeNode root = new TreeNode(max);
        if(maxIndex+1 <= end) {
            root.right = helper(nums, maxIndex+1, end);
        }
        if(maxIndex-1 >= start) {
            root.left = helper(nums, start, maxIndex-1);
        }
        return root;
    }

    private int getMaxIndex(int[] nums, int start, int end) {
        int max = nums[start];
        int index = start;
        for(int i=start; i<=end; i++) {
            if(nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }
}