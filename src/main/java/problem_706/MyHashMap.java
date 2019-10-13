package main.java.problem_706;

public class MyHashMap {

    /** Initialize your data structure here. */
    ListNode[] bucket;
    public MyHashMap() {
        bucket = new ListNode[10000];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = this.getHash(key);
        ListNode node = bucket[hash];
        if(node == null) {
            bucket[hash] = new ListNode(key, value);
        } else {
            ListNode prev = node;
            while(node != null) {
                if(prev.key == key) {
                    prev.val = value;
                    break;
                }
                prev=node;
                node = node.next;
            }
            if(node == null) {
                if(prev.key == key) {
                    prev.val = value;
                } else {
                    prev.next = new ListNode(key, value);
                }
            }
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = this.getHash(key);
        ListNode node = bucket[hash];
        if(node == null) {
            return -1;
        } else {
            ListNode prev = node;
            while(node != null) {
                if(prev.key == key) {
                    return prev.val;
                }
                prev=node;
                node = node.next;
            }
            if(node == null) {
                if(prev.key == key) {
                    return prev.val;
                }
            }
            return -1;
        }
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = this.getHash(key);
        ListNode node = bucket[hash];
        if(node != null) {
            ListNode prev = node;
            while(node != null) {
                if(node.key == key) {
                    prev.next = prev.next.next;
                }
                prev = node;
                node = node.next;
            }
        }
    }

    private int getHash(int key) {
        return Integer.hashCode(key) % bucket.length;
    }

    class ListNode {
        int key, val;
        ListNode next;
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
