package leetcode.easy;

import java.util.Arrays;

public class DecodeXORedArray1720 {

    public int[] decode(int[] encoded, int first) {
        int[] array = new int[encoded.length + 1];
        array[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            int firstXor = array[i];
            int resultXor = encoded[i];
            int secondXor = firstXor ^ resultXor;
            array[i + 1] = secondXor;
        }
        return array;
    }

    public static void main(String[] args) {
        DecodeXORedArray1720 decodeXORedArray1720 = new DecodeXORedArray1720();
        System.out.println(Arrays.toString(decodeXORedArray1720.decode(new int[]{1, 2, 3}, 1))); // [1, 0, 2, 1]
        System.out.println(Arrays.toString(decodeXORedArray1720.decode(new int[]{6, 2, 7, 3}, 4))); // [4, 2, 0, 7, 4]
    }

}
