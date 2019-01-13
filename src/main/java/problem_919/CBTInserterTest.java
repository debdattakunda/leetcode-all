package main.java.problem_919;

import org.junit.Test;

import static org.junit.Assert.*;

public class CBTInserterTest {

    @Test
    public void insert() {
        CBTInserter.TreeNode treeNode = new CBTInserter.TreeNode(1);
        CBTInserter inserter = new CBTInserter(treeNode);
        int val = inserter.insert(2);
        int val2 = inserter.insert(3);
        int val3 = inserter.insert(4);
        int val4 = inserter.insert(5);
    }

    @Test
    public void get_root() {
    }
}