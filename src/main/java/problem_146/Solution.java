package main.java.problem_146;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 * LRUCache cache = new LRUCache( 2 // capacity );
        *
        *cache.put(1,1);
        *cache.put(2,2);
        *cache.get(1);       // returns 1
        *cache.put(3,3);    // evicts key 2
        *cache.get(2);       // returns -1 (not found)
        *cache.put(4,4);    // evicts key 1
        *cache.get(1);       // returns -1 (not found)
        *cache.get(3);       // returns 3
        *cache.get(4);       // returns 4
 */

public class Solution {

    private final int capacity;
    private Map<Integer, ListNode> map;
    private ListNode head;
    private ListNode tail;

    class ListNode {
        private int key;
        private int val;
        ListNode previous;
        ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public Solution(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new ListNode(0, 0);
        this.tail = new ListNode(0, 0);
        head.next = tail;
        tail.previous = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            this.deleteNode(node);
            this.addToHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.val = value;
            this.deleteNode(node);
            this.addToHead(node);
            map.put(key, node);
        } else {
            if (map.size() == capacity) {
                ListNode node = tail.previous;
                map.remove(node.key);
                deleteNode(node);
            }
            ListNode node = new ListNode(key, value);
            this.addToHead(node);
            map.put(key, node);
        }
    }

    private void addToHead(ListNode node) {
        head.next.previous = node;
        node.next = head.next;
        head.next = node;
        node.previous = head;
    }

    private void deleteNode(ListNode node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
