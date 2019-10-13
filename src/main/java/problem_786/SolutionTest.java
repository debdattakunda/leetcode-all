package main.java.problem_786;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void kthSmallestPrimeFraction() {
        Solution solution = new Solution();
        solution.kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3);
    }
}