package leetcode.easy;

import java.util.Stack;

public class BaseballGame682 {

    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("C")) {
                stack.pop();
            } else if (operations[i].equals("D")) {
                stack.add(stack.peek() * 2);
            } else if (operations[i].equals("+")) {
                int first = stack.pop();
                int newValue = first + stack.peek();
                stack.push(first);
                stack.push(newValue);
            } else {
                stack.push(Integer.parseInt(operations[i]));
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        BaseballGame682 baseballGame682 = new BaseballGame682();
        System.out.println(baseballGame682.calPoints(new String[]{"5", "2", "C", "D", "+"})); // 30
        System.out.println(baseballGame682.calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"})); // 27
        System.out.println(baseballGame682.calPoints(new String[]{"1", "C"})); // 0
    }
}
