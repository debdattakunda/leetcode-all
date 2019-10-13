package main.java.problem_542;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void updateMatrix() {
        int[][] grid = new int[][]{{0,1,0},{0,1,0},{0,1,0},{0,1,0},{0,1,0}};
        Solution solution = new Solution();
        solution.updateMatrix(grid);
    }
}