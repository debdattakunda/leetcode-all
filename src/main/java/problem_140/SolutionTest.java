package main.java.problem_140;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void wordBreak() {
        String s = "pineapplepenapple";
        String[] wordDict = new String[]{"apple","pen","applepen","pine","pineapple"};
        Solution solution = new Solution();
        List<String> result = solution.wordBreak(s, Arrays.asList(wordDict));
        for(String str : result) {
            System.out.println(str);
        }
    }
}