package main.java.problem_42;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 *
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 *
 * Example:
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */

public class Solution {
    public int trap(int[] height) {

        int[] leftHighest = new int[height.length + 1];
        leftHighest[0] = 0;
        for(int i=0; i<height.length; i++) {
            leftHighest[i+1] = Math.max(height[i], leftHighest[i]);
        }
        int total = 0;
        int rightHighest = 0;
        for(int j=height.length-1; j>=0; j--) {
            rightHighest = Math.max(rightHighest, height[j]);
            if(Math.min(leftHighest[j], rightHighest) > height[j]) {
                total = total +  Math.min(leftHighest[j], rightHighest) - height[j];
            }
        }
        return total;
    }
}
