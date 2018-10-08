package main.java.problem_227;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void calculate() {
        Solution solution = new Solution();
        String str = "1*2-3/4+5*6-7*8+9/10";
        int res = solution.calculate2(str);
        assertEquals(7, res);
    }
}