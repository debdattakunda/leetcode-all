package main.java.problem_442;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @problem-statement : Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements that appear twice in this array.
 *
 * Could you do it without extra space and in O(n) runtime?
 *
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [2,3]
 */

class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        int low = 0;
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int high = 1; high<nums.length; high++) {
            if(nums[low] != nums[high]) {
                low++;
                nums[low] = nums[high];
            } else {
                result.add(nums[high]);
            }
        }
        return result;
    }
}
