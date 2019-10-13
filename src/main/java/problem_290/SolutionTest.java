package main.java.problem_290;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void wordPattern() {
        Solution sol = new Solution();
        sol.wordPattern("deadbeef", "d e a d b e e f");
    }
}