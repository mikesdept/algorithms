package leetcode.medium;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class SimplifyPath71 {

    public String simplifyPath(String path) {
        String[] files = path.split("/");
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedBlockingQueue<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (String file : files) {
            if (!file.isEmpty() && !isCurrentDirectory(file)) {
                if (isUpDirectory(file)) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    stack.push(file);
                }
            }
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }
        if (stack.isEmpty()) {
            stringBuilder.append("/");
        }
        while (!stack.isEmpty()) {
            stringBuilder.append("/").append(stack.pop());
        }
        return stringBuilder.toString();
    }

    private boolean isCurrentDirectory(String file) {
        return file.equals(".");
    }

    private boolean isUpDirectory(String file) {
        return file.equals("..");
    }

    public static void main(String[] args) {
        SimplifyPath71 simplifyPath71 = new SimplifyPath71();
        System.out.println(simplifyPath71.simplifyPath("/home/")); // "/home"
        System.out.println(simplifyPath71.simplifyPath("/../")); // "/"
        System.out.println(simplifyPath71.simplifyPath("/home//foo/")); // "/home/foo"
        System.out.println(simplifyPath71.simplifyPath("/a/../../b/../c//.//")); // "/c"
    }

}
