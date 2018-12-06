package main.java.problem_347;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void topKFrequent() {
        Solution solution = new Solution();
        int[] nums = new int[] {1,1,1,2,2,3};
        List<Integer> list = solution.topKFrequent(nums, 2);
    }
}