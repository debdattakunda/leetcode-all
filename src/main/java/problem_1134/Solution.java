package main.java.problem_1134;

public class Solution {
    public boolean isArmstrong(int N) {
        int k=1, num=N, check=N;
        while(N>1) {
            N /= 10;
            k++;
        }
        int sum=0;
        while(num>1) {
            int den = num%10;
            sum += Math.pow(den, k);
            num /=10;
        }
        return sum==check;
    }
}