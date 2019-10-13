package main.java.problem_349;

public class Solution {
    public String decodeString(String s) {

        int slow=0, fast=0;
        if(s == null || s.length() == 0) return s;
        StringBuilder sb = new StringBuilder();
        while(slow < s.length()) {
            Character ch = s.charAt(slow);
            if(Character.isDigit(ch)) {
                fast=slow;
                while(Character.isDigit(s.charAt(fast))) {
                    fast++;
                }
                int num = Integer.parseInt(s.substring(slow, fast));
                slow=fast;
                fast++;
                int open=1;

                while(fast < s.length() && open != 0) {
                    if(s.charAt(fast) == '[') {
                        open++;
                    }else if(s.charAt(fast) == ']') {
                        open--;
                    }
                    fast++;
                }
                String temp = decodeString(s.substring(slow+1, fast-1));
                while(num != 0) {
                    sb.append(temp);
                    num--;
                }
                slow=fast;
            } else {
                sb.append(s.substring(slow, slow+1));
                slow++;
            }
        }
        return sb.toString();
    }
}
