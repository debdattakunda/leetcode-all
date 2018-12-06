package main.java.problem_5;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 */

public class Solution {
    public String longestPalindrome(String s) {
        int low = 0;
        int high = 0;
        if(s.length() == 0) return s;
        boolean[][] grid = new boolean[s.length()][s.length()];
        for(int i=0; i<s.length(); i++) {
            grid[i][i] = true;
            low = i;
            high = i;
        }
        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i-1) == s.charAt(i)) {
                grid[i-1][i] = true;
                low = i-1;
                high = i;
            }
        }
        for(int j=2; j<s.length(); j++) {
            for(int i=0; i<j; i++) {
                if(s.charAt(i) == s.charAt(j) && grid[i+1][j-1]) {
                    grid[i][j] = true;
                    if(j-i > high-low) {
                        low = i;
                        high = j;
                    }
                }
            }
        }
        return s.substring(low, high+1);
    }
}
