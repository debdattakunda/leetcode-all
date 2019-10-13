package main.java.problem_1100;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numKLenSubstrNoRepeats(String S, int K) {

        if(K>S.length()) return 0;
        int low=0, high=K-1, count=0;
        Set<Character> seen = new HashSet<>();
        for(int i=low; i<=high; i++) {
            // if(seen.contains(S.charAt(i))) break;
            seen.add(S.charAt(i));
        }
        if(seen.size()==K) count++;
        while(high<S.length()) {
            seen.remove(S.charAt(low));
            high++;
            if(high>=S.length()) break;
            seen.add(S.charAt(high));
            if(seen.size()==K) count++;
            low++;
        }
        return count;
    }
}
