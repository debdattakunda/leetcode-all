package main.java.problem_78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @problem-statement : Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        helper(nums, new ArrayList<>(), result, 0);
        return result;
    }

    private void helper(int[] nums, List<Integer> list, List<List<Integer>> result, int index) {

        result.add(new ArrayList<>(list));
        if(index == nums.length) {
            return;
        }
        for(int i=index; i<nums.length; i++) {
            list.add(nums[i]);
            helper(nums, list, result, i+1);
            list.remove(list.size()-1);
        }
    }
}
