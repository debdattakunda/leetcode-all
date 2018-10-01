package main.java.problem_189;

public class Solution {
    public void rotate(int[] nums, int k) {

        while(k != 0) {
            int temp = 0;
            int last = nums[nums.length-1];
            for(int i=0; i<nums.length; i++) {
                temp = nums[i];
                nums[i] = last;
                last = temp;
            }
            k--;
        }
    }
}
