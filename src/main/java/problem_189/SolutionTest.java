package main.java.problem_189;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void rotate() {
        int[] orig = new int[]{1,2,3,4,5,6,7};
        int[] exp = new int[]{5,6,7,1,2,3,4};
        Solution solution = new Solution();
        solution.rotate(orig, 3);
        assertArrayEquals(exp, orig);
    }
}