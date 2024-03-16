package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class HappyNumber202 {

    public boolean isHappy(int n) {
        List<Integer> resultList = new ArrayList<>();
        int result = n;
        while (result != 1 && !resultList.contains(result)) {
            resultList.add(result);
            result = getNumber(result);
        }
        return result == 1;
    }

    private int getNumber(int n) {
        int result = 0;
        int digit = 0;
        int pow = -1;
        int length = String.valueOf(n).length();
        while (length != 0) {
            pow++;
            digit = n / (int) Math.pow(10, pow) % 10;
            result += digit * digit;
            length--;
        }
        return result;
    }

    public static void main(String[] args) {
        HappyNumber202 happyNumber202 = new HappyNumber202();
        System.out.println(happyNumber202.isHappy(19)); // true
        System.out.println(happyNumber202.isHappy(2)); // false
    }

}
