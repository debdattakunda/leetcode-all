package main.java.problem_1056;

public class Solution {
    public boolean confusingNumber(int N) {
        int[] array = new int[]{0,1,-1,-1,-1,-1,9,-1,8,6};

        int num = N, factor=0, newNum=0;
        while(num >= 1) {
            factor++;
            num=num/10;
        }
        num=N;
        factor--;
        while(num >= 1) {
            int reminder = num%10;
            if(array[reminder] == -1) return false;
            reminder = array[reminder];
            num=num/10;
            newNum = newNum + reminder * (int) Math.pow(10, factor--);
        }
        return N != newNum;
    }
}
