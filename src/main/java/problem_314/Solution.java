package main.java.problem_314;

import java.util.*;

/**
 *@problem-statement : Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 *
 * If two nodes are in the same row and column, the order should be from left to right.
 *
 * Examples 1:
 *
 * Input: [3,9,20,null,null,15,7]
 *
 *    3
 *   /\
 *  /  \
 *  9  20
 *     /\
 *    /  \
 *   15   7
 *
 * Output:
 *
 * [
 *   [9],
 *   [3,15],
 *   [20],
 *   [7]
 * ]
 * Examples 2:
 *
 * Input: [3,9,8,4,0,1,7]
 *
 *      3
 *     /\
 *    /  \
 *    9   8
 *   /\  /\
 *  /  \/  \
 *  4  01   7
 *
 * Output:
 *
 * [
 *   [4],
 *   [9],
 *   [3,0,1],
 *   [8],
 *   [7]
 * ]
 * Examples 3:
 *
 * Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)
 *
 *      3
 *     /\
 *    /  \
 *    9   8
 *   /\  /\
 *  /  \/  \
 *  4  01   7
 *     /\
 *    /  \
 *    5   2
 *
 * Output:
 *
 * [
 *   [4],
 *   [9,5],
 *   [3,0,1],
 *   [8,2],
 *   [7]
 * ]
 */

class Solution {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root != null) {
            Queue<Holder> queue = new LinkedList<>();
            Holder main = new Holder();
            main.root = root;
            main.rank = 0;
            queue.offer(main);
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size != 0) {
                    Holder currHolder = queue.poll();
                    List<Integer> list = map.getOrDefault(currHolder.rank, new ArrayList<Integer>());
                    list.add(currHolder.root.val);
                    map.put(currHolder.rank, list);
                    if (currHolder.root.left != null) {
                        Holder lHolder = new Holder();
                        lHolder.root = currHolder.root.left;
                        lHolder.rank = currHolder.rank - 1;
                        queue.offer(lHolder);
                    }
                    if (currHolder.root.right != null) {
                        Holder rHolder = new Holder();
                        rHolder.root = currHolder.root.right;
                        rHolder.rank = currHolder.rank + 1;
                        queue.offer(rHolder);
                    }
                    size--;
                }
            }
            for (Integer num : map.keySet()) {
                result.add(map.get(num));
            }
        }
        return result;
    }

    private class Holder {
        TreeNode root;
        int rank;
    }
}
