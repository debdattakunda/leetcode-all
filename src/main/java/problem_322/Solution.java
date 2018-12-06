package main.java.problem_322;

/**
 * @problem-statement : You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */

public class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] T = new int[amount+1];
        T[0] = 0;
        for(int i=1; i<T.length; i++) {
            T[i] = Integer.MAX_VALUE-1;
        }
        for(int j=0; j<coins.length; j++) {
            for(int i=0; i<T.length; i++) {
                if(i >= coins[j]) {
                    if(1 + T[i - coins[j]] < T[i]) {
                        T[i] = 1 + T[i - coins[j]];
                    }
                }
            }
        }
        return T[amount] == Integer.MAX_VALUE-1 ? -1 : T[amount];
    }
}
