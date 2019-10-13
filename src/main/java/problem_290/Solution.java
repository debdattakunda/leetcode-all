package main.java.problem_290;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean wordPattern(String pattern, String str) {

        int index=0;
        StringBuilder sb = new StringBuilder();
        String[] letters = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        Map<String, String> map = new HashMap<>();
        for(String st : str.split("[' ']")) {
            if(map.containsKey(st)) {
                sb.append(map.get(st));
            } else {
                map.put(st, letters[index]);
                sb.append(letters[index]);
                index++;
            }
        }
        String matcher = sb.toString();
        if(matcher.length() != pattern.length()) {
            return false;
        }
        char[] arr1 = new char[256];
        char[] arr2 = new char[256];
        for(int i=0; i<pattern.length(); i++) {
            if(arr1[pattern.charAt(i)] == 0 && arr2[matcher.charAt(i)] == 0) {
                arr1[pattern.charAt(i)] = matcher.charAt(i);
                arr2[matcher.charAt(i)] = pattern.charAt(i);
            } else {
                if(arr1[pattern.charAt(i)] == arr2[matcher.charAt(i)]) {
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}
