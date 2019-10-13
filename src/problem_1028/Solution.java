package problem_1028;

class Solution {
    public TreeNode recoverFromPreorder(String S) {
        StringBuilder delimeter = new StringBuilder();
        delimeter.append("-");
        return buildTree(S, delimeter);
    }

    private TreeNode buildTree(String expression, StringBuilder delimeter) {

        String[] array = expression.split( "-", 2);
        if (array == null || array.length == 0 || array[0].equals("")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(array[0]));
        delimeter.append("-");
        if (array.length > 1) {
            root.left = buildTree(array[1], delimeter);
        }
        if (array.length > 2) {
            root.right = buildTree(array[2], delimeter);
        }
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
