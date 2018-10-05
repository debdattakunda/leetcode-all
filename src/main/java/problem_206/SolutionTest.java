package main.java.problem_206;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void reverseList() {

        Solution solution = new Solution();
        Solution.ListNode listNode = solution.new ListNode(1);
        Solution.ListNode node1 = solution.new ListNode(2);
        Solution.ListNode node2 = solution.new ListNode(3);
        Solution.ListNode node3 = solution.new ListNode(4);
        Solution.ListNode node4 = solution.new ListNode(5);
        Solution.ListNode node5 = solution.new ListNode(6);

        node4.next = node5;
        node3.next = node4;
        node2.next = node3;
        node1.next = node2;
        listNode.next = node1;

        Solution.ListNode reversedListNode = solution.reverseList(listNode);
        assertEquals(reversedListNode.val, node5.val);
        assertEquals(reversedListNode.next.val, node4.val);
        assertEquals(reversedListNode.next.next.val, node3.val);
    }
}