package main.java.problem_929;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(String email : emails) {
            String[] array = email.split("@");
            String temp = array[0].replace(".", "");
            temp = temp.substring(0, temp.indexOf("+")-1);
            // array[0] = array[0].replace(".", "").substring(0, array[0].indexOf("+")-1);
            StringBuilder sb = new StringBuilder();
            sb.append(temp).append(array[1]);
            set.add(sb.toString());
        }
        return set.size();
    }
}
