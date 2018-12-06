package main.java.problem_70;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void climbStairs() {
        Solution solution = new Solution();
        Assert.assertEquals(8, solution.climbStairs(5));
    }
}