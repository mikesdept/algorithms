package leetcode.easy;

public class HappyNumber202 {

    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = getSquareNumber(slow);
            fast = getSquareNumber(getSquareNumber(fast));
        } while (slow != fast);
        return slow == 1;
    }

    private int getSquareNumber(int n) {
        int answer = 0;
        while (n > 0) {
            int remainder = n % 10;
            answer += remainder * remainder;
            n /= 10;
        }
        return answer;
    }

    public static void main(String[] args) {
        HappyNumber202 happyNumber202 = new HappyNumber202();
        System.out.println(happyNumber202.isHappy(19)); // true
        System.out.println(happyNumber202.isHappy(2)); // false
    }

}
