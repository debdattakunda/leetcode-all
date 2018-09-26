package main.java.problem_693;

/**
 * @author: Debdatta Kunda
 * @problem-statement:
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.
 *
 * Write a function to compute all possible states of the string after one valid move.
 *
 * Example:
 *
 * Input: s = "++++"
 * Output:
 * [
 *   "--++",
 *   "+--+",
 *   "++--"
 * ]
 * Note: If there is no valid move, return an empty list [].
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generatePossibleNextMoves(String s) {

        int l = 0;
        int r = 1;
        char[] array = s.toCharArray();
        List<String> list = new ArrayList<>();
        while (r < array.length) {
            if (array[l] == '+' && array[r] == '+') {
                array[l] = '-';
                array[r] = '-';
                list.add(new String(array));
                array[l] = '+';
                array[r] = '+';
            }
            l++;
            r++;
        }
        return list;
    }
}
