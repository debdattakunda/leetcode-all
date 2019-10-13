package main.java.problem_648;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void replaceWords() {
        Solution solution = new Solution();
        List<String> dict = Arrays.asList(new String[]{"cat", "bat", "rat"});
        solution.replaceWords(dict, "the cattle was rattled by the battery");
    }
}