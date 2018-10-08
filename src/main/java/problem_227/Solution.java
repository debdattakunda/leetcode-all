package main.java.problem_227;

import java.util.Stack;

public class Solution {
    public int calculate(String s) {

        Stack<Character> nums = new Stack<>();
        Stack<Character> oper = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                oper.push(ch);
            } else {
                nums.push(ch);
            }
        }
        while (!oper.isEmpty()) {
            int num1 = 0;
            int num2 = 0;
            int res = 0;
            char operator = oper.pop();
            switch (operator) {
                case '/':
                    num1 = Character.getNumericValue(nums.pop());
                    num2 = Character.getNumericValue(nums.pop());
                    res = num2 / num1;
                    nums.push((char) (res + '0'));
                    break;

                case '*':
                    num1 = Character.getNumericValue(nums.pop());
                    num2 = Character.getNumericValue(nums.pop());
                    res = num2 * num1;
                    nums.push((char) (res + '0'));
                    break;

                case '-':
                    num1 = Character.getNumericValue(nums.pop());
                    num2 = Character.getNumericValue(nums.pop());
                    res = num2 - num1;
                    nums.push((char) (res + '0'));
                    break;

                case '+':
                    num1 = Character.getNumericValue(nums.pop());
                    num2 = Character.getNumericValue(nums.pop());
                    res = num2 + num1;
                    nums.push((char) (res + '0'));
                    break;
            }
        }
        return (int) nums.pop() - '0';
    }

    public int calculate2(String s) {

        int result = 0;
        String[] sumArray = s.split("['+']");
        for (String str : sumArray) {
            String[] subArray = str.split("-");
            for (String sub : subArray) {
                Stack<Character> nums = new Stack<>();
                Stack<Character> oper = new Stack<>();
                for (Character ch : sub.toCharArray()) {
                    if (ch == '*' || ch == '/') {
                        oper.push(ch);
                    } else {
                        nums.push(ch);
                    }
                }
                result = result + helper(nums, oper);
            }
        }
        return result;

    }

    private int helper(Stack<Character> nums, Stack<Character> oper) {

        while (!oper.isEmpty()) {
            int num1 = 0;
            int num2 = 0;
            int res = 0;
            char operator = oper.pop();
            switch (operator) {
                case '/':
                    num1 = Character.getNumericValue(nums.pop());
                    num2 = Character.getNumericValue(nums.pop());
                    res = num2 / num1;
                    nums.push((char) (res + '0'));
                    break;

                case '*':
                    num1 = Character.getNumericValue(nums.pop());
                    num2 = Character.getNumericValue(nums.pop());
                    res = num2 * num1;
                    nums.push((char) (res + '0'));
                    break;
            }
        }
        return (int) nums.pop() - '0';
    }
}
