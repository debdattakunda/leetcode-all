package main.java.problem_70;

public class Solution {
    public int climbStairs(int n) {
        if(n == 1 || n == 2) {
            return n;
        }
        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n; i++) {
            int temp = dp[1];
            dp[1] = dp[1] + dp[0];
            dp[0] = temp;
        }
        return dp[1];
    }
}
