package main.java.problem_200;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private String str1;
    private String str2;
    private Solution solution;

    @Before
    public void setup() {
        this.str1 = "abcd";
        this.str2 = "abcde";
        this.solution = new Solution();
    }
    @Test
    public void numIslands() {
        char[][] grid = new char[][]{{'1','1','1',}, {'0','1','1',}, {'0','0','1'}, {'1','0','0'}};
        int num = solution.numIslands(grid);
        assertEquals(2, num);
    }
}