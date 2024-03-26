package leetcode.easy;

public class FindTheHighestAltitude1732 {

    public int largestAltitude(int[] gain) {
        int largestAltitude = 0;
        int currentAltitude = 0;
        for (int item : gain) {
            currentAltitude += item;
            largestAltitude = Math.max(largestAltitude, currentAltitude);
        }
        return largestAltitude;
    }

    public static void main(String[] args) {
        FindTheHighestAltitude1732 findTheHighestAltitude1732 = new FindTheHighestAltitude1732();
        System.out.println(findTheHighestAltitude1732.largestAltitude(new int[]{-5, 1, 5, 0, -7})); // 1
        System.out.println(findTheHighestAltitude1732.largestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2})); // 0
    }
}
