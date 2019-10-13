package main.java.problem_706;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyHashMapTest {

    @Test
    public void put() {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1,1);
        hashMap.put(2,2);
        int val = hashMap.get(1);
    }

    @Test
    public void get() {
    }

    @Test
    public void remove() {
    }
}