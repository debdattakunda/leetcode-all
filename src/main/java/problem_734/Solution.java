package main.java.problem_734;

import java.util.*;

public class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {

        if(words1.length != words2.length) {
            return false;
        }
        if(pairs == null || pairs.length == 0) {
            return Arrays.equals(words1, words2) ? true : false;
        }
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(int i=0; i<pairs.length; i++) {
            List<String> list = map.getOrDefault(pairs[i][0], new ArrayList<>());
            list.add(pairs[i][1]);
            map.put(pairs[i][0], list);
        }
        for(int i=0; i<words1.length; i++) {
            if(words1[i].equals(words2[i])) {
                continue;
            }
            if(!map.containsKey(words1[i]) && !map.containsKey(words2[i])) {
                return false;
            }
            if(map.containsKey(words1[i]) && map.get(words1[i]).contains(words2[i])) {
                continue;
            }
            if(map.containsKey(words2[i]) && map.get(words2[i]).contains(words1[i])) {
                continue;
            }
            return false;
        }
        return true;
    }
}