package main.java.problem_212;

import java.util.*;

class Solution {
    TrieNode root;
    public List<String> findWords(char[][] board, String[] words) {
        this.root = new TrieNode();
        for(String word : words) {
            this.insert(word);
        }
        Set<Character> seen = new HashSet<>();
        List<String> result = new ArrayList<>();
        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                this.search(board, i, j, directions, new boolean[board.length][board[0].length], root, new ArrayList<>(), result);
            }
        }
        return result;
    }

    private void search(char[][] board, int row, int col, int[][] directions, boolean[][] visited, TrieNode node, List<Character> list, List<String> result) {

        if(row<0 || row>board.length-1 || col<0 || col>board[0].length-1 || visited[row][col]) {
            return;
        }
        if(node.endOfWord) {
            char[] array = new char[list.size()];
            for(int i=0; i<list.size(); i++) {
                array[i] = list.get(i);
            }
            result.add(String.valueOf(array));
        }
        TrieNode currNode = node.children.get(board[row][col]);
        if(currNode != null) {
            visited[row][col]=true;
            list.add(board[row][col]);
            for(int i=0; i<directions.length; i++) {
                search(board, row+directions[i][0], col+directions[i][1], directions, visited, currNode, list, result);
            }
            list.remove(list.size()-1);
            visited[row][col]=false;
        }
    }

    private void insert(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++) {
            TrieNode currNode = node.children.get(word.charAt(i));
            if(currNode == null) {
                currNode = new TrieNode();
                node.children.put(word.charAt(i), currNode);
            }
            node = currNode;
        }
        node.endOfWord=true;
    }

    class TrieNode {
        boolean endOfWord;
        Map<Character, TrieNode> children;
        public TrieNode() {
            this.children = new HashMap<>();
        }
    }
}
