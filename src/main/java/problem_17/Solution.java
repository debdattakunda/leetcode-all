package main.java.problem_17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @problem-statement : Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 *
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */

public class Solution {

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0) {
            return result;
        }
        Map<Integer, Character[]> map = new HashMap<>();
        map.put(2, new Character[]{'a', 'b', 'c'});
        map.put(3, new Character[]{'d', 'e', 'f'});
        map.put(4, new Character[]{'g', 'h', 'i'});
        map.put(5, new Character[]{'j', 'k', 'l'});
        map.put(6, new Character[]{'m', 'n', 'o'});
        map.put(7, new Character[]{'p', 'q', 'r', 's'});
        map.put(8, new Character[]{'t', 'u', 'v'});
        map.put(9, new Character[]{'w', 'x', 'y', 'z'});
        List<Character[]> list = new ArrayList<>();
        for(int i=0; i<digits.length(); i++) {
            int key = digits.charAt(i) - '0';
            list.add(map.get(key));
        }
        char[] array = new char[digits.length()];
        helper(list, 0, array, result);
        return result;
    }

    private void helper(List<Character[]> list, int level, char[] array, List<String> result) {
        if(level == array.length) {
            result.add(new String(array));
            return;
        }
        for(char ch : list.get(level)) {
            array[level] = ch;
            level++;
            helper(list, level, array, result);
            level--;
        }
    }
}
