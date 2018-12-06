package main.java.problem_39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @problem-statement : Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, result, combination, 0);
        return result;
    }

    private void helper(int[] candidates, int target, List<List<Integer>> result, List<Integer> combination, int index) {

        if(target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        for(int i=index; i<candidates.length; i++) {
            if(target < candidates[i]) {
                return;
            }
            combination.add(candidates[i]);
            helper(candidates, target-candidates[i], result, combination, i);
            combination.remove(combination.size()-1);
        }
    }
}
