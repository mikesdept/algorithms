package leetcode.medium;

import java.util.LinkedList;

public class BasicCalculator227 {

    public int calculate(String s) {
        int number = 0;
        Character previousOperator = ' ';
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i <= s.length(); i++) {
            Character character = i < s.length() ? s.charAt(i) : ' ';
            if (Character.isDigit(character)) {
                number = number * 10 + ((int) character - (int) '0');
            } else if (!Character.isWhitespace(character) || i == s.length()) {
                if (previousOperator == ' ') {
                    stack.addLast(number);
                } else if (previousOperator == '+') {
                    stack.addLast(number);
                } else if (previousOperator == '-') {
                    stack.addLast(number * -1);
                } else if (previousOperator == '*') {
                    stack.addLast(stack.pollLast() * number);
                } else if (previousOperator == '/') {
                    stack.addLast(stack.pollLast() / number);
                }
                previousOperator = character;
                number = 0;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pollLast();
        }
        return result;
    }

    public static void main(String[] args) {
        BasicCalculator227 basicCalculator227 = new BasicCalculator227();
        System.out.println(basicCalculator227.calculate("3+2*2")); // 7
        System.out.println(basicCalculator227.calculate("3/2")); // 1
        System.out.println(basicCalculator227.calculate(" 3+5 / 2 ")); // 5
    }
}
