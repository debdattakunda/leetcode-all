package main.java.problem_648;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    TrieNode root;
    public String replaceWords(List<String> dict, String sentence) {
        this.root = new TrieNode();
        for(String str : dict) {
            this.insertIntoTrie(str);
        }
        StringBuilder result = new StringBuilder();
        String[] arr = sentence.split("\\s");
        for(String str : arr) {
            StringBuilder sb = new StringBuilder();
            if(this.search(root, str, 0, sb)) {
                result.append(sb.toString()).append(" ");
            } else {
                result.append(str).append(" ");
            }
        }
        return result.substring(0, result.length()-1);
    }

    private boolean search(TrieNode node, String str, int index, StringBuilder sb) {
        if(node.endOfWord) {
            return true;
        }
        if(index==str.length()) {
            return false;
        }
        TrieNode currNode = node.children.get(str.charAt(index));
        if(currNode==null) {
            return false;
        }
        sb.append(str.charAt(index));
        return search(currNode, str, index+1, sb);
    }

    private void insertIntoTrie(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode currNode = node.children.get(ch);
            if(currNode==null) {
                currNode = new TrieNode();
                node.children.put(ch, currNode);
            }
            node=currNode;
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
