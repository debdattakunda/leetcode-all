package main.java.problem_796;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyHashMapTest {

    private MyHashMap myHashMap;
    @Before
    public void setUp() {
        myHashMap=new MyHashMap();
    }
    @Test
    public void put() {
        myHashMap.put(1,1);
        myHashMap.put(2,2);
        myHashMap.put(4,4);
    }

    @Test
    public void get() {

    }

    @Test
    public void remove() {
    }
}