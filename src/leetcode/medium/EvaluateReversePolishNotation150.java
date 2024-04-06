package leetcode.medium;

import java.util.LinkedList;

public class EvaluateReversePolishNotation150 {

    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                stack.addLast(stack.pollLast() + stack.pollLast());
            } else if (token.equals("-")) {
                int second = stack.pollLast();
                int first = stack.pollLast();
                stack.addLast(first - second);
            } else if (token.equals("*")) {
                stack.addLast(stack.pollLast() * stack.pollLast());
            } else if (token.equals("/")) {
                int second = stack.pollLast();
                int first = stack.pollLast();
                stack.addLast(first / second);
            } else {
                stack.addLast(Integer.parseInt(token));
            }
        }
        return stack.pollLast();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation150 evaluateReversePolishNotation150 = new EvaluateReversePolishNotation150();
        System.out.println(evaluateReversePolishNotation150.evalRPN(new String[]{"2", "1", "+", "3", "*"})); // 9
        System.out.println(evaluateReversePolishNotation150.evalRPN(new String[]{"4", "13", "5", "/", "+"})); // 6
        System.out.println(evaluateReversePolishNotation150.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"})); // 22
    }

}
