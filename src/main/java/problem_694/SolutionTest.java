package main.java.problem_694;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void numDistinctIslands() {

        int[][] grid = new int[][]{{1,1,0,0}, {1,1,0,0}, {0,0,1,1}, {0,0,1,1}};
        Solution solution = new Solution();
        assertEquals(1, solution.numDistinctIslands(grid));
    }
}