package main.java.problem_559;

import java.util.List;

/**
 * @author: Debdatta Kunda
 * @problem-statement:
 * Given a n-ary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * For example, given a 3-ary tree:
 *
 *
 *
 *
 *
 * We should return its max depth, which is 3.
 *
 * Note:
 *
 * The depth of the tree is at most 1000.
 * The total number of nodes is at most 5000.
 *
 */

public class Solution {

    public class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    int maxDepth = 0;
    public int maxDepth(Node root) {
        if(root == null) {
            return 0;
        }
        if(root.children == null || root.children.isEmpty()) {
            return 1;
        }
        helper(root, maxDepth);
        return maxDepth;
    }

    private int helper(Node root, int depth) {

        if(root.children != null) {
            depth++;
            for(Node child : root.children) {
                int temp = helper(child, depth);
                if(temp > maxDepth) {
                    maxDepth = temp;
                }
            }
        }
        return depth;
    }
}
