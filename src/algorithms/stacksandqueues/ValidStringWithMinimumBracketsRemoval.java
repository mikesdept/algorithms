package algorithms.stacksandqueues;

import java.util.Stack;

public class ValidStringWithMinimumBracketsRemoval {

    public String minRemoveToMakeValid(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        } else {
            Stack<Integer> stack = new Stack<>();
            String[] array = s.split("");
            for (int i = 0; i < array.length; i++) {
                if (array[i].equals("(")) {
                    stack.add(i);
                } else if (array[i].equals(")")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        array[i] = "";
                    }
                }
            }
            while (!stack.isEmpty()) {
                int indexToRemove = stack.pop();
                array[indexToRemove] = "";
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (String value : array) {
                stringBuilder.append(value);
            }
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        ValidStringWithMinimumBracketsRemoval validStringWithMinimumBracketsRemoval = new ValidStringWithMinimumBracketsRemoval();
        System.out.println(validStringWithMinimumBracketsRemoval.minRemoveToMakeValid(null)); // null
        System.out.println(validStringWithMinimumBracketsRemoval.minRemoveToMakeValid("")); // ""
        System.out.println(validStringWithMinimumBracketsRemoval.minRemoveToMakeValid("(abcd)")); // (abcd)
        System.out.println(validStringWithMinimumBracketsRemoval.minRemoveToMakeValid("(abc(d))")); // (abc(d))
        System.out.println(validStringWithMinimumBracketsRemoval.minRemoveToMakeValid("(abc(d)")); // abc(d)
        System.out.println(validStringWithMinimumBracketsRemoval.minRemoveToMakeValid("(abc(d(")); // abcd
        System.out.println(validStringWithMinimumBracketsRemoval.minRemoveToMakeValid("(ab)c(d(")); // (ab)cd
        System.out.println(validStringWithMinimumBracketsRemoval.minRemoveToMakeValid("(ab)c)(d(")); // (ab)cd
        System.out.println(validStringWithMinimumBracketsRemoval.minRemoveToMakeValid("(ab)c)(d)(")); // (ab)c(d)
    }
}
