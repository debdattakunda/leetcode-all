package main.java.problem_1085;

public class Solution {
    public int sumOfDigits(int[] A) {
        int min = Integer.MAX_VALUE;
        for(int num : A) {
            min = Math.min(num, min);
        }
        int sum=0;
        while(min > 0) {
            sum += min%10;
            min /= 10;
        }
        return sum%2==0 ? 1 : 0;
    }
}