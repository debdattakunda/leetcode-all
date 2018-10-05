package main.java.problem_46;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @problem-statement : Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */

class Solution {

    List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for(Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int index = 0;
        int[] array = new int[map.size()];
        int[] frequency = new int[map.size()];
        int[] result = new int[nums.length];

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            array[index] = entry.getKey();
            frequency[index] = entry.getValue();
            index++;
        }
        helper(array, frequency, result, 0);
        return resultList;
    }

    private void helper(int[] array, int[] frequency, int[] result, int level) {

        if(level == result.length) {
            List<Integer> levelList = new ArrayList<Integer>();
            for(int num : result) {
                levelList.add(num);
            }
            resultList.add(levelList);
            return;
        }
        for(int i=0; i<array.length; i++) {
            if(frequency[i] == 0) {
                continue;
            }
            frequency[i]--;
            result[level] = array[i];
            helper(array, frequency, result, level+1);
            frequency[i]++;
        }
    }
}
