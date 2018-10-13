package main.java.problem_365;

public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {

        if((x+y) < z) {
            return false;
        }
        if(x == y || y == z) {
            return true;
        }
        return z%gcd(x,y) == 0;
    }

    private int gcd(int x, int y) {

        while(y != 0) {
            int temp = y;
            y = x%y;
            x = temp;
        }
        return x;
    }
}
