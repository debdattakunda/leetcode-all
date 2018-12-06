package main.java.problem_78;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void subsets() {
        int[] array = new int[]{1,5,4,7,8,3};
        Solution solution = new Solution();
        List<List<Integer>> result = solution.subsets(array);
        assertNotNull(result);
    }
}