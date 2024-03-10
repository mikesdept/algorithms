package leetcode.easy;

public class NthTribonacciNumber1137 {

    public int tribonacci(int n) {
        int length = n < 3 ? 3 : n + 1;
        int[] array = new int[length];
        array[0] = 0;
        array[1] = 1;
        array[2] = 1;
        if (n < 3) {
            return array[n];
        }
        for (int i = 3; i < array.length; i++) {
            array[i] = array[i - 1] + array[i - 2] + array[i - 3];
        }
        return array[array.length - 1];
    }

    public static void main(String[] args) {
        NthTribonacciNumber1137 nthTribonacciNumber1137 = new NthTribonacciNumber1137();
        System.out.println(nthTribonacciNumber1137.tribonacci(4)); // 4
        System.out.println(nthTribonacciNumber1137.tribonacci(25)); // 1389537
        System.out.println(nthTribonacciNumber1137.tribonacci(0)); // 0
    }

}
