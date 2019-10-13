package main.java.problem_212;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void findWords() {
        Solution solution = new Solution();
        solution.findWords(new char[][]{{'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}}, new String[]{"oath","pea","eat","rain"});
    }
}