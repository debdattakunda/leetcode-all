package main.java.problem_693;


import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void generatePossibleNextMoves() {

        Solution solution = new Solution();
        List<String> list = solution.generatePossibleNextMoves("++++");

        assertNotNull(list);
        assertEquals(true, list.contains("--++"));
        assertEquals(true, list.contains("+--+"));
        assertEquals(true, list.contains("++--"));
    }
}