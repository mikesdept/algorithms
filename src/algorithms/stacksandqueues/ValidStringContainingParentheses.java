package algorithms.stacksandqueues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidStringContainingParentheses {

    public boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) {
            return false;
        } else if (s.length() == 0) {
            return true;
        } else {
            Map<Character, Character> map = new HashMap<>();
            map.put(']', '[');
            map.put('}', '{');
            map.put(')', '(');
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char bracket = s.charAt(i);
                if (map.containsValue(bracket)) {
                    stack.add(bracket);
                } else if (map.containsKey(bracket)) {
                    if (stack.isEmpty() || !stack.pop().equals(map.get(bracket))) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        ValidStringContainingParentheses validStringContainingParentheses = new ValidStringContainingParentheses();
        System.out.println(validStringContainingParentheses.isValid(null)); // false
        System.out.println(validStringContainingParentheses.isValid("")); // true
        System.out.println(validStringContainingParentheses.isValid("[{()}]")); // true
        System.out.println(validStringContainingParentheses.isValid("[(){}]")); // true
        System.out.println(validStringContainingParentheses.isValid("[({)}]")); // false
        System.out.println(validStringContainingParentheses.isValid("[]{}()")); // true
        System.out.println(validStringContainingParentheses.isValid("[{((}]")); // false
        System.out.println(validStringContainingParentheses.isValid("[({)]")); // false
        System.out.println(validStringContainingParentheses.isValid("((")); // false
    }

}
