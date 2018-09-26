package main.java.problem_389;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private String str1;
    private String str2;
    private Solution solution;

    @Before
    public void setup() {
        this.str1 = "abcd";
        this.str2 = "abcde";
        this.solution = new Solution();
    }

    @Test
    public void findTheDifferenceApproachOne() {
        char result = this.solution.findTheDifferenceApproachOne(this.str1, this.str2);
        assertEquals('e', result);
    }

    @Test
    public void findTheDifferenceApproachtwo() {
        char result = this.solution.findTheDifferenceApproachtwo(this.str1, this.str2);
        assertEquals('e', result);
    }
}