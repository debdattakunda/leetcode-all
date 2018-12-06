package main.java.problem_140;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {

        if(s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        Set<String> set = new HashSet<>(wordDict);
        boolean[][] grid = new boolean[s.length()][s.length()];
        for(int i=0; i<s.length(); i++) {
            if(set.contains(s.substring(i, i+1))) {
                grid[i][i] = true;
            }
        }
        for(int i=1; i<s.length(); i++) {
            int low = 0;
            int high = i;
            while(high < s.length()) {
                String temp = s.substring(low, high+1);
                if(set.contains(temp)) {
                    grid[low][high] = true;
                }
                low++;
                high++;
            }
        }
        List<String> result = new ArrayList<>();
        helper(grid, 0, s, result, new StringBuilder());
        return result;
    }

    private void helper(boolean[][] grid, int begin, String s, List<String> result, StringBuilder sb) {

        if(begin > grid.length-1) {
            result.add(sb.toString().trim());
            return;
        }
        for(int i=begin; i<grid[0].length; i++) {
            if(grid[begin][i] == true) {
                String temp = s.substring(begin, i+1);
                sb.append(temp);
                sb.append(" ");
                helper(grid, i+1, s, result, sb);
                sb.delete(sb.lastIndexOf(" "), sb.length());
                sb.delete(sb.lastIndexOf(temp), sb.length());
            }
        }
    }
}