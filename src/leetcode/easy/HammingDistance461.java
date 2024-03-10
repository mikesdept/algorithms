package leetcode.easy;

public class HammingDistance461 {

    public int hammingDistance(int x, int y) {
        int max = Math.max(x, y);
        int maxLength = 0;
        int maxDividedByTwo = max;
        while (maxDividedByTwo != 0) {
            maxDividedByTwo /= 2;
            maxLength++;
        }
        int currentBitIndex = 0;
        int hammingDistance = 0;
        while (maxLength != 0) {
            int xBit = (x & (1 << currentBitIndex)) == 0 ? 0 : 1;
            int yBit = (y & (1 << currentBitIndex)) == 0 ? 0 : 1;
            if (xBit != yBit) {
                hammingDistance++;
            }
            maxLength--;
            currentBitIndex++;
        }
        return hammingDistance;
    }

    public static void main(String[] args) {
        HammingDistance461 hammingDistance461 = new HammingDistance461();
        System.out.println(hammingDistance461.hammingDistance(1, 4)); // 2
        System.out.println(hammingDistance461.hammingDistance(3, 1)); // 1
    }

}
