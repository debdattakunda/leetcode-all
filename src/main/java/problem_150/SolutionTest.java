package main.java.problem_150;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void evalRPN() {

        Solution solution = new Solution();
        int result = solution.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});
        assertEquals(22, result);
    }
}