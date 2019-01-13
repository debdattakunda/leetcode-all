package main.java.problem_919;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class CBTInserter {

    TreeNode root;
    Queue<TreeNode> queue = new LinkedList<>();
    public CBTInserter(TreeNode root) {
        this.root = root;
        boolean shouldInsert = true;
        queue.offer(root);
        while(shouldInsert) {
            boolean leftPresent = false;;
            boolean rightPresent = false;;
            TreeNode currNode = queue.peek();
            if(currNode.left != null) {
                queue.offer(currNode.left);
                leftPresent = true;
            } else {
                shouldInsert = false;
            }
            if(currNode.right != null) {
                queue.offer(currNode.right);
                rightPresent = true;
            } else {
                shouldInsert = false;
            }
            if(leftPresent && rightPresent) {
                queue.poll();
            }
        }
    }

    public int insert(int v) {
        TreeNode currNode = queue.peek();
        boolean leftPresent = currNode.left != null;
        boolean rightPresent = currNode.right != null;
        if(!leftPresent) {
            currNode.left = new TreeNode(v);
            queue.offer(currNode.left);
            leftPresent = true;
        } else if(!rightPresent) {
            currNode.right = new TreeNode(v);
            queue.offer(currNode.right);
            rightPresent = true;
        }
        if(leftPresent && rightPresent) {
            queue.poll();
        }
        return currNode.val;
    }

    public TreeNode get_root() {
        return this.root;
    }

    /**
     * Your CBTInserter object will be instantiated and called as such:
     * CBTInserter obj = new CBTInserter(root);
     * int param_1 = obj.insert(v);
     * TreeNode param_2 = obj.get_root();
     */
      public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
