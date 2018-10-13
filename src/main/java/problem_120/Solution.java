package main.java.problem_120;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @problem-statement : Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */

public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {

        Queue<Integer> queue = new LinkedList<>();
        for(int num : triangle.get(triangle.size()-1)) {
            queue.offer(num);
        }
        int index = triangle.size()-2;
        while(queue.size() != 1) {
            int prev = queue.poll();
            for(int num : triangle.get(index)) {
                int curr = queue.poll();
                queue.offer(Math.min(num+prev, num+curr));
                prev = curr;
            }
            index--;
        }
        return queue.poll();
    }
}
