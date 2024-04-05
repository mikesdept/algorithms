package leetcode.easy;

import java.util.LinkedList;

public class BaseballGame682 {

    public int calPoints(String[] operations) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("C")) {
                stack.pollLast();
            } else if (operations[i].equals("D")) {
                stack.addLast(stack.peekLast() * 2);
            } else if (operations[i].equals("+")) {
                int first = stack.pollLast();
                int newValue = first + stack.peekLast();
                stack.addLast(first);
                stack.addLast(newValue);
            } else {
                stack.addLast(Integer.parseInt(operations[i]));
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pollLast();
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
