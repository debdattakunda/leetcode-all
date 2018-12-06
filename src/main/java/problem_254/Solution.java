package main.java.problem_254;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        if(n < 2) {
            return result;
        }
        List<Integer> factors = new ArrayList<>();
        helper(factors, result, 2, n, n);
        return result;
    }

    private void helper(List<Integer> factors, List<List<Integer>> result, int index, int target, int n) {

        if(target == 1) {
            result.add(new ArrayList<>(factors));
            return;
        }
        if(target < 1) {
            return;
        }
        for(int i=index; i<n; i++) {
            if(target%i != 0) {
                continue;
            }
            if(target%i == 0) {
                factors.add(i);
                helper(factors, result, i, target/i, n);
                factors.remove(factors.size()-1);
            }
        }
    }
}