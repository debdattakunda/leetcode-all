package main.java.problem_92;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void reverseBetween() {

        Solution solution = new Solution();
        Solution.ListNode listNode = solution.new ListNode(1);
        listNode.next = solution.new ListNode(2);
        listNode.next.next = solution.new ListNode(3);
        listNode.next.next.next = solution.new ListNode(4);
        listNode.next.next.next.next = solution.new ListNode(5);
        listNode.next.next.next.next.next = solution.new ListNode(6);

        Solution.ListNode result = solution.reverseBetween(listNode, 2, 4);

        assertEquals(1, result.val);
        assertEquals(4, result.next.val);
        assertEquals(3, result.next.next.val);
        assertEquals(2, result.next.next.next.val);
        assertEquals(5, result.next.next.next.next.val);
        assertEquals(6, result.next.next.next.next.next.val);
    }
}