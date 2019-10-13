package main.java.problem_394;

public class Solution {
    public String decodeString(String s) {
        if(s==null || s.length()==0) return s;
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i<s.length()) {
            if(Character.isDigit(s.charAt(i))) {
                int start=i;
                while(Character.isDigit(s.charAt(i))) {
                    i++;
                }
                int prefix = Integer.parseInt(s.substring(start, i)), open=0, close=0;
                start=i;
                while(i<s.length() && (open != close || open==0)) {
                    if('['==s.charAt(i)) {
                        open++;
                    } else if(']'==s.charAt(i)) {
                        close++;
                    }
                    i++;
                }
                String str = s.substring(start+1, i-1);
                String temp = decodeString(str);
                for(int j=0; j<prefix; j++) {
                    sb.append(temp);
                }
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}
