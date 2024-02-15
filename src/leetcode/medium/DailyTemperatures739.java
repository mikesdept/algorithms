package leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DailyTemperatures739 {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                map.put(stack.peek(), i - stack.pop());
            }
            stack.push(i);
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = map.getOrDefault(i, 0);
        }
        return result;
    }

    public static void main(String[] args) {
        DailyTemperatures739 dailyTemperatures739 = new DailyTemperatures739();
        System.out.println(Arrays.toString(dailyTemperatures739.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}))); // [1,1,4,2,1,1,0,0]
        System.out.println(Arrays.toString(dailyTemperatures739.dailyTemperatures(new int[]{30, 40, 50, 60}))); // [1,1,1,0]
        System.out.println(Arrays.toString(dailyTemperatures739.dailyTemperatures(new int[]{30, 60, 90}))); // [1,1,0]
    }

}
