package main.java.problem_2;

/**
 * @problem-statement : You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return helper(l1, l2, 0);
    }

    private ListNode helper(ListNode l1, ListNode l2, int carry) {

        if (l1 == null && l2 == null) {
            if (carry != 0) {
                return new ListNode(carry);
            }
            return null;
        }
        int temp = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
        carry = 0;
        if (temp > 9) {
            carry = temp / 10;
            temp = temp % 10;
        }
        ListNode node = new ListNode(temp);
        node.next = helper(l1 == null ? null : l1.next, l2 == null ? null : l2.next, carry);
        return node;
    }
}
