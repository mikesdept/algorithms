package lectures.twopointers;

public class TwoPointersSum {

    public boolean isSumExist(int[] array, int x) {
        if (array == null || array.length < 2) {
            return false;
        }
        int leftPointer = 0;
        int rightPointer = array.length - 1;
        int checkSum = 0;
        do {
            if (array[leftPointer] + array[rightPointer] > x) {
                rightPointer--;
            } else if (array[leftPointer] + array[rightPointer] < x) {
                leftPointer++;
            } else {
                return true;
            }
        } while (checkSum != x && leftPointer < rightPointer);
        return false;
    }

    public static void main(String[] args) {
        TwoPointersSum twoPointersSum = new TwoPointersSum();
        System.out.println(twoPointersSum.isSumExist(new int[]{5, 8, 10, 14, 18, 30}, 24)); // true
        System.out.println(twoPointersSum.isSumExist(new int[]{5, 8, 10, 14, 18, 30}, 19)); // true
        System.out.println(twoPointersSum.isSumExist(new int[]{5, 8, 10, 14, 18, 30}, 40)); // true
        System.out.println(twoPointersSum.isSumExist(new int[]{5, 8, 10, 14, 18, 30}, 35)); // true
        System.out.println(twoPointersSum.isSumExist(new int[]{5, 8, 10, 14, 18, 30}, 26)); // true
        System.out.println(twoPointersSum.isSumExist(new int[]{5, 8, 10, 14, 18, 30}, 25)); // false
        System.out.println(twoPointersSum.isSumExist(new int[]{5, 8, 10, 14, 18, 30}, 27)); // false
    }

}
