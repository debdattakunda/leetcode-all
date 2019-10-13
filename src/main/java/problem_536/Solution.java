package main.java.problem_536;

class Solution {
    public TreeNode str2tree(String s) {
        return build(s);
    }

    private TreeNode build(String expression) {

        if (expression.length() == 0) return null;
        TreeNode root = new TreeNode(Integer.parseInt(Character.toString(expression.charAt(0))));
        int leftCount = 0, rightCount = 0, leftIndex = 0, rightIndex = 0;
        String left = "", right = "";
        for (int i = 1; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                if (leftCount == 0) {
                    leftIndex = i;
                }
                leftCount++;
            }
            if (expression.charAt(i) == ')') {
                rightCount++;
            }
            if (leftCount == rightCount) {
                rightIndex = i;
                if (left.length() == 0) {
                    left = expression.substring(leftIndex + 1, rightIndex);
                } else {
                    right = expression.substring(leftIndex + 1, rightIndex);
                }
                leftCount = 0;
                rightCount = 0;
            }
        }
        root.left = build(left);
        root.right = build(right);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}