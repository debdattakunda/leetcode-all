package main.java.problem_536;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void str2tree() {
        Solution solution = new Solution();
        solution.str2tree("4(2(3)(1))(6(5))");
    }
}