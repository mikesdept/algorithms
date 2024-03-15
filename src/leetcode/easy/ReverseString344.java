package leetcode.easy;

public class ReverseString344 {

    public void reverseString(char[] s) {
        int leftIndex = 0;
        int rightIndex = s.length - 1;
        while (leftIndex <= rightIndex) {
            char tempChar = s[leftIndex];
            s[leftIndex] = s[rightIndex];
            s[rightIndex] = tempChar;
            leftIndex++;
            rightIndex--;
        }
    }

    public static void main(String[] args) {
        ReverseString344 reverseString344 = new ReverseString344();
        char[] first = new char[]{'h', 'e', 'l', 'l', 'o'};
        char[] second = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString344.reverseString(first);
        reverseString344.reverseString(second);
        System.out.println(first); // ['o', 'l', 'l', 'e', 'h']
        System.out.println(second); // ['h', 'a', 'n', 'n', 'a', 'H']
    }
}
