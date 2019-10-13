package main.java.problem_279;

public class Solution {
    int result=Integer.MAX_VALUE;
    public int numSquares(int n) {
        this.backtrack(n, 0, n);
        return result;
    }

    private void backtrack(int target, int count, int n) {
        if(target<=0) {
            if(target==0) {
                this.result = Math.min(this.result, count);
            }
            return;
        }
        for(int i=1; i<n; i++) {
            int square = (int) Math.pow(i, i);
            if(square < n) {
                backtrack(target-square, count+1, n);
            }
        }
    }
}
