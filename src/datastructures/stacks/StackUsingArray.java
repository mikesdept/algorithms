package datastructures.stacks;

import java.util.ArrayList;
import java.util.List;

public class StackUsingArray {

    private final List<Integer> list = new ArrayList<>();

    public Integer peek() {
        Integer value = null;
        if (!isEmpty()) {
            value = list.get(list.size() - 1);
        }
        return value;
    }

    public void push(int value) {
        list.add(value);
    }

    public Integer pop() {
        Integer value = null;
        if (!isEmpty()) {
            value = list.remove(list.size() - 1);
        }
        return value;
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int getLength() {
        return list.size();
    }

    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("length -> " + stack.getLength());
        System.out.println("peek -> " + stack.peek());
        System.out.println("length -> " + stack.getLength());
        System.out.println("pop -> " + stack.pop());
        System.out.println("length -> " + stack.getLength());
        System.out.println("isEmpty -> " + stack.isEmpty());
        System.out.println("pop -> " + stack.pop());
        System.out.println("length -> " + stack.getLength());
        System.out.println("isEmpty -> " + stack.isEmpty());
        System.out.println("pop -> " + stack.pop());
        System.out.println("length -> " + stack.getLength());
        System.out.println("isEmpty -> " + stack.isEmpty());
        System.out.println("pop -> " + stack.pop());
        System.out.println("length -> " + stack.getLength());
        System.out.println("isEmpty -> " + stack.isEmpty());
        /*
        output should be:
        length -> 3
        peek -> 3
        length -> 3
        pop -> 3
        length -> 2
        isEmpty -> false
        pop -> 2
        length -> 1
        isEmpty -> false
        pop -> 1
        length -> 0
        isEmpty -> true
        pop -> null
        length -> 0
        isEmpty -> true
         */
    }

}
