package main.java.problem_206;

import java.util.Stack;

/**
 *
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */

public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode result = null;
        Stack<ListNode> stack = new Stack<>();
        while(head != null) {
            stack.push(head);
            head = head.next;
        }
        return helper(result, stack);
    }

    private ListNode helper(ListNode result, Stack<ListNode> stack) {
        if(stack.isEmpty()) {
            return result;
        }
        result = new ListNode(stack.pop().val);
        result.next = helper(result.next, stack);
        return result;
    }
}
