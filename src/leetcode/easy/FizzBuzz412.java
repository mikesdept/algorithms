package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz412 {

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FizzBuzz412 fizzBuzz412 = new FizzBuzz412();
        System.out.println(fizzBuzz412.fizzBuzz(3)); // [1, 2, Fizz]
        System.out.println(fizzBuzz412.fizzBuzz(5)); // [1, 2, Fizz, 4, Buzz]
        System.out.println(fizzBuzz412.fizzBuzz(15)); // [1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz]
    }
}
