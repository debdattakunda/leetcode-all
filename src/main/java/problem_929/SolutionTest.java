package main.java.problem_929;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void numUniqueEmails() {
        String[] array = new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        Solution solution = new Solution();
        solution.numUniqueEmails(array);
    }
}