package main.java.problem_516;

public class Solution {
    public int longestPalindromeSubseq(String s) {
        if(s == null || s.length() == 0) return 0;
        int length = s.length();
        int[][] dp = new int[length][length];
        for(int i=0; i<length; i++) {
            dp[i][i] = 1;
        }
        for(int i=1; i<length; i++) {
            if(s.charAt(i-1) == s.charAt(i)) {
                dp[i-1][i] = 2;
            } else {
                dp[i-1][i] = 1;
            }
        }
        for(int j=2; j<length; j++) {
            int low = 0;
            int high = j;
            while(high < length) {
                if(s.charAt(low) == s.charAt(high)) {
                    dp[low][high] = dp[low+1][high-1] + 2;
                } else {
                    dp[low][high] = Math.max(dp[low][high-1], dp[low+1][high]);
                }
                low++;
                high++;
            }
        }
        return dp[0][length-1];
    }
}