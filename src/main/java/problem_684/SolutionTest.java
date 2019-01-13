package main.java.problem_684;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void findRedundantConnection() {
        int[][] connections = new int[][]{{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
        Solution solution = new Solution();
        int[] result = solution.findRedundantConnection(connections);
        Assert.assertEquals(1, result[0]);
        Assert.assertEquals(4, result[1]);
    }
}