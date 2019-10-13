package main.java.problem_comcast;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Debdatta Kunda
 * @date June 13, 2019
 */
public class SolutionTest {

    private Solution solution;

    @Before
    public void setUp() {
        this.solution = new Solution();
    }

    @Test
    public void wrapText1() {
        System.out.println("---TEST CASE 1---");
        List<String> result = this.solution.wrapText("Four score and seven years ago our fathers brought forth upon this continent a new nation, conceived in liberty and dedicated to the proposition that all men are created equal");
        Assert.assertNotNull(result.size());
        Assert.assertEquals(16, result.size());
        for(String line : result) {
            System.out.println(line);
        }
    }

    @Test
    public void wrapText2() {
        System.out.println("---TEST CASE 2---");
        List<String> result = this.solution.wrapText("On offering to help the blind man, the man who then stole his car, had not, at that precise moment, had any evil intention, quite the contrary, what he did was nothing more than obey those feelings of generosity and altruism which, as everyone knows, are the two best traits of human nature and to be found in much more hardened criminals than this one, a simple car-thief without any hope of advancing in his profession, exploited by the real owners of this enterprise, for it is they who take advantage of the needs of the poor.");
        Assert.assertNotNull(result.size());
        Assert.assertEquals(48, result.size());
        for(String line : result) {
            System.out.println(line);
        }
    }

    @Test
    public void wrapText3() {
        System.out.println("---TEST CASE 3---");
        List<String> result = this.solution.wrapText("My very photogenic mother died in a freak accident (picnic, lightning) when I was three, and, save for a pocket of warmth in the darkest past, nothing of her subsists within the hollows and dells of memory, over which, if you can still stand my style (I am writing under observation), the sun of my infancy had set: surely, you all know those redolent remnants of day suspended, with the midges, about some hedge in bloom or suddenly entered and traversed by the rambler, at the bottom of a hill, in the summer dusk; a furry warmth, golden midges");
        Assert.assertNotNull(result.size());
        Assert.assertEquals(48, result.size());
        for(String line : result) {
            System.out.println(line);
        }
    }
}