package main.java.problem_347;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        int[] frequency = new int[10];
        for(int i=0; i<nums.length; i++) {
            frequency[nums[i]]++;
        }
        List<Integer> result = new ArrayList<>();
        for(int j=0; j<k; j++) {
            int max = 0;
            for(int p=0; p<frequency.length; p++) {
                if(frequency[p] > max) {
                    max = p;
                }
            }
            result.add(max);
            frequency[max] = 0;
        }
        return result;
    }
}
