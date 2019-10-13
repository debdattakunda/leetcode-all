package problem_1028;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void recoverFromPreorder() {
        Solution solution = new Solution();
        solution.recoverFromPreorder("1-2--3--4-5--6--7");
    }
}