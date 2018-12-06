package main.java.problem_88;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void merge() {

        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        Solution solution = new Solution();
        solution.merge(nums1, 3, nums2, 3);
    }
}