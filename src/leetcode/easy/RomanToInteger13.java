package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger13 {

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0;
        int lastValue = map.get(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            int currentValue = map.get(s.charAt(i));
            int addition;
            if (lastValue < currentValue) {
                addition = currentValue - (lastValue * 2);
            } else {
                addition = currentValue;
            }
            result += addition;
            lastValue = currentValue;

        }
        return result;
    }

    public static void main(String[] args) {
        RomanToInteger13 romanToInteger13 = new RomanToInteger13();
        System.out.println(romanToInteger13.romanToInt("III")); // 3
        System.out.println(romanToInteger13.romanToInt("LVIII")); // 58
        System.out.println(romanToInteger13.romanToInt("MCMXCIV")); // 1994
    }
}
