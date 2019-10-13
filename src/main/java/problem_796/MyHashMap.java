package main.java.problem_796;

public class MyHashMap {

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1,1);
        myHashMap.put(2,2);
        myHashMap.put(4,4);
        int num = myHashMap.get(1);
        int num2 = myHashMap.get(2);
    }
    /** Initialize your data structure here. */
    ListNode[] bucket;
    public MyHashMap() {
        bucket = new ListNode[10000];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index=this.getNodeIndex(key);
        ListNode node = bucket[index];
        if(node==null) {
            node=new ListNode(key, value);
            return;
        } else {
            ListNode prev=node;
            while(node!=null) {
                if(prev.key==key) {
                    prev.val=value;
                    return;
                }
                prev=node;
                node=node.next;
            }
            if(prev.key==key) {
                prev.val=value;
            } else {
                prev.next=new ListNode(key, value);
            }
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index=this.getNodeIndex(key);
        ListNode node = bucket[index];
        if(node==null) {
            return -1;
        } else {
            ListNode prev=node;
            while(node!=null) {
                if(prev.key==key) {
                    return prev.val;
                }
                prev=node;
                node=node.next;
            }
            if(prev.key==key) return prev.val;
            return -1;
        }
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index=this.getNodeIndex(key);
        ListNode node = bucket[index];
        if(node!=null) {
            while(node!=null) {
                if(node.key==key) {
                    node.next=node.next.next;
                    break;
                }
                node=node.next;
            }
        }
    }

    private int getNodeIndex(int key) {
        return Integer.hashCode(key) % bucket.length;
    }

    class ListNode {
        int key, val;
        ListNode next;
        public ListNode(int key, int val) {
            this.key=key;
            this.val=val;
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
