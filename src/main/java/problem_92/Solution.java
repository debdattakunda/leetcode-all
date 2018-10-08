package main.java.problem_92;

import java.util.Stack;

public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {

        if(head == null || head.next == null || m == n) {
            return head;
        }
        Stack<ListNode> main = new Stack<>();
        Stack<ListNode> holder = new Stack<>();
        Stack<ListNode> aux = new Stack<>();
        while(head != null) {
            main.push(head);
            head = head.next;
        }
        while(!main.isEmpty()) {
            if(main.size() == n) {
                while(main.size() != m-1) {
                    aux.push(main.pop());
                }
                while(!aux.isEmpty()) {
                    holder.push(aux.pop());
                }
            }
            if(main.size() != 0) {
                holder.push(main.pop());
            }
        }
        return buildList(null, holder);
    }

    private ListNode buildList(ListNode head, Stack<ListNode> holder) {
        if(holder.isEmpty()) {
            return head;
        }
        head = new ListNode(holder.pop().val);
        head.next = buildList(null, holder);
        return head;
    }
}
