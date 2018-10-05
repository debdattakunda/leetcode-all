package main.java.problem_60;

import java.util.ArrayList;
import java.util.List;

/**
 * @problem-statement : The set [1,2,3,...,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Note:
 *
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * Example 1:
 *
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 *
 * Input: n = 4, k = 9
 * Output: "2314"
 */

class Solution {

    int count = 0;
    List<String> resultList = new ArrayList<String>();
    public String getPermutation(int n, int k) {

        char[] input = new char[n];
        int[] freq = new int[n];
        for(int i=0; i<input.length; i++) {
            int temp = i+1;
            input[i] = (char) (temp + '0');
            freq[i] = 1;
        }
        char[] result = new char[n];
        helper(input, freq, result, 0, k);
        return resultList.get(k-1);
    }

    private void helper(char[] input, int[] freq, char[] result, int level, int k) {
        if(level == result.length) {
            resultList.add(new String(result));
            count++;
            return;
        }
        for(int i=0; i<input.length; i++) {
            if(freq[i] == 0) {
                continue;
            }
            if(count == k) {
                break;
            }
            freq[i]--;
            result[level] = input[i];
            helper(input, freq, result, level+1, k);
            freq[i]++;
        }
    }
}
