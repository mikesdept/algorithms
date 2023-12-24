package lectures.stack;

import java.util.Arrays;
import java.util.Stack;

public class MonotonicStack {

    public int[] convertToNextMoreElement(int[] array) {
        if (array == null) {
            return null;
        }
        Stack<StackValue> stack = new Stack<>();
        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int currentValue = array[i];
            if (stack.isEmpty()) {
                stack.add(new StackValue(i, currentValue));
            } else {
                while (!stack.isEmpty() && stack.peek().getValue() < currentValue) {
                    result[stack.pop().getIndex()] = currentValue;
                }
                stack.add(new StackValue(i, currentValue));
            }
        }
        while (!stack.isEmpty()) {
            StackValue stackValue = stack.pop();
            result[stackValue.getIndex()] = -1;
        }
        return result;
    }

    public static void main(String[] args) {
        MonotonicStack monotonicStack = new MonotonicStack();
        System.out.println(Arrays.toString(monotonicStack.convertToNextMoreElement(new int[]{3, 1, 2, 4, 1, 3, 2}))); // 4, 2, 4, -1, 3, -1, -1
        System.out.println(Arrays.toString(monotonicStack.convertToNextMoreElement(new int[]{1, 2, 3}))); // 2, 3, -1
        System.out.println(Arrays.toString(monotonicStack.convertToNextMoreElement(new int[]{3, 2, 1}))); // -1, -1, -1
        System.out.println(Arrays.toString(monotonicStack.convertToNextMoreElement(new int[]{2, 4}))); // 4, -1
        System.out.println(Arrays.toString(monotonicStack.convertToNextMoreElement(new int[]{4, 2}))); // -1, -1
        System.out.println(Arrays.toString(monotonicStack.convertToNextMoreElement(new int[]{2, 2}))); // -1, -1
        System.out.println(Arrays.toString(monotonicStack.convertToNextMoreElement(new int[]{2}))); // -1
        System.out.println(Arrays.toString(monotonicStack.convertToNextMoreElement(null))); // null
    }

    private static class StackValue {

        private final int index;
        private final int value;

        public StackValue(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public int getValue() {
            return value;
        }

    }

}
