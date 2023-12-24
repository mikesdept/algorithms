package lectures.binarysearch;

public class FindSqrtRoundedDown {

    public int findSqrt(int x) {
        if (x < 0) {
            return -1;
        }
        if (x == 0) {
            return 0;
        }
        int lastValue = x * 2;
        int size = (int) Math.sqrt(lastValue) + 1;
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = i * i;
        }
        int leftIndex = 0;
        int rightIndex = size - 1;
        int currentIndex = 0;
        while (leftIndex <= rightIndex) {
            currentIndex = (leftIndex + rightIndex) / 2;
            if (array[currentIndex] < x) {
                leftIndex = currentIndex + 1;
            } else if (array[currentIndex] > x) {
                rightIndex = currentIndex - 1;
            } else {
                break;
            }
        }
        if (array[currentIndex] > x) {
            return currentIndex - 1;
        } else {
            return currentIndex;
        }
    }

    public static void main(String[] args) {
        FindSqrtRoundedDown findSqrtRoundedDown = new FindSqrtRoundedDown();
        System.out.println(findSqrtRoundedDown.findSqrt(180)); // 13
        System.out.println(findSqrtRoundedDown.findSqrt(400)); // 20
        System.out.println(findSqrtRoundedDown.findSqrt(200)); // 14
        System.out.println(findSqrtRoundedDown.findSqrt(225)); // 15
        System.out.println(findSqrtRoundedDown.findSqrt(100)); // 10
        System.out.println(findSqrtRoundedDown.findSqrt(-25)); // -1
        System.out.println(findSqrtRoundedDown.findSqrt(0)); // 0
        System.out.println(findSqrtRoundedDown.findSqrt(1)); // 1
        System.out.println(findSqrtRoundedDown.findSqrt(2)); // 1
        System.out.println(findSqrtRoundedDown.findSqrt(3)); // 1
        System.out.println(findSqrtRoundedDown.findSqrt(5)); // 2
        System.out.println(findSqrtRoundedDown.findSqrt(168)); // 12
        System.out.println(findSqrtRoundedDown.findSqrt(169)); // 13
        System.out.println(findSqrtRoundedDown.findSqrt(170)); // 13
    }
}
