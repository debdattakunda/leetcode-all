package main.java.problem_48;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class SolutionTest {

    @Test
    @SuppressWarnings("deprecation")
    public void rotate() {
        int[][] orig = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] expected = new int[][]{{7,4,1}, {8,5,2}, {9,6,3}};
        Solution solution = new Solution();
        solution.rotate(orig);
        assertEquals(expected, orig);
    }
}