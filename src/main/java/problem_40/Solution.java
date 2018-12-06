package main.java.problem_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @problem-statement : Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> combinations = new ArrayList<>();
        helper(candidates, target, result, 0, combinations, 0);
        return result;
    }

    private void helper(int[] candidates, int target, List<List<Integer>> result, int index, List<Integer> combinations, int lastRemoved) {
        if(target == 0) {
            result.add(new ArrayList<>(combinations));
            return;
        }
        for(int i=index; i<candidates.length; i++) {
            if(candidates[i] == lastRemoved) {
                continue;
            }
            if(candidates[i] > target) {
                break;
            }
            combinations.add(candidates[i]);
            helper(candidates, target-candidates[i], result, i+1, combinations, lastRemoved);
            lastRemoved = combinations.remove(combinations.size()-1);
        }
    }
}

// Second Approach.

//public class Solution {
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        List<List<Integer>> result = new ArrayList<>();
//        if(candidates == null || candidates.length == 0) return result;
//        Arrays.sort(candidates);
//        List<Integer> combination = new ArrayList<>();
//        helper(candidates, target, combination, result, 0);
//        return result;
//    }
//
//    private void helper(int[] candidates, int target, List<Integer> combination, List<List<Integer>> result, int index) {
//
//        if(target == 0) {
//            result.add(new ArrayList<>(combination));
//            return;
//        }
//        for(int i=index; i<candidates.length; i++) {
//            if(i > index && candidates[i-1] == candidates[i]) {
//                continue;
//            }
//            if(target < candidates[i]) {
//                return;
//            }
//            combination.add(candidates[i]);
//            helper(candidates, target-candidates[i], combination, result, i+1);
//            combination.remove(combination.size()-1);
//        }
//    }
//}
