package main.java.problem_comcast;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Debdatta Kunda
 * @date June 13, 2019
 */
public class Solution {

    private static final int MAX_LIMIT = 13;

    public List<String> wrapText(String input) {

        List<String> result = new ArrayList<>();
        String[] words = input.split("[' ']");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (sb.length() <= MAX_LIMIT && (sb.length() + word.length()) <= MAX_LIMIT) {
                sb.append(word).append(" ");
            } else {
                result.add(sb.substring(0, sb.length() - 1));
                sb.setLength(0);
                sb.append(word).append(" ");
            }
        }
        if (sb.length() > 1) result.add(sb.substring(0, sb.length() - 1));
        return result;
    }
}
