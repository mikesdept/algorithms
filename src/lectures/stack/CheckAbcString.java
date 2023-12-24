package lectures.stack;

import java.util.Stack;

public class CheckAbcString {

    public boolean isAbcValid(String t) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < t.length(); i++) {
            stack.add(t.charAt(i));
            if (stack.size() >= 3 && stack.get(stack.size() - 3) == 'a' && stack.get(stack.size() - 2) == 'b' && stack.get(stack.size() - 1) == 'c') {
                stack.pop();
                stack.pop();
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        CheckAbcString checkAbcString = new CheckAbcString();
        System.out.println(checkAbcString.isAbcValid("abcabcababcc")); // true
        System.out.println(checkAbcString.isAbcValid("abaabcabcbcc")); // true
        System.out.println(checkAbcString.isAbcValid("abcabbcbaabc")); // false
    }

}
