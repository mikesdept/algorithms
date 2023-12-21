package lectures.cows;

public class ArrangeCowsInStalls {

    public int arrange(int[] stallsIndexesArray, int cowsCount) {
        if (1 >= cowsCount || cowsCount >= stallsIndexesArray.length) {
            return -1;
        }
        int minX = 1;
        int maxX = stallsIndexesArray[stallsIndexesArray.length - 1];
        int currentX;
        int latestPossibleX = minX;
        while (minX <= maxX) {
            currentX = (minX + maxX) / 2;
            if (checkIfPossibleToArrangeCowsInStalls(currentX, stallsIndexesArray, cowsCount)) {
                latestPossibleX = currentX;
                minX = currentX + 1;
            } else {
                maxX = currentX - 1;
            }
        }
        return latestPossibleX;
    }

    private boolean checkIfPossibleToArrangeCowsInStalls(int x, int[] stallsIndexesArray, int cowsCount) {
        int placedCows = 1;
        int previousPlacedIndex = stallsIndexesArray[0];
        for (int i = 1; i < stallsIndexesArray.length; i++) {
            if (stallsIndexesArray[i] - previousPlacedIndex >= x) {
                placedCows++;
                previousPlacedIndex = stallsIndexesArray[i];
            }
        }
        if (placedCows >= cowsCount) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        ArrangeCowsInStalls arrangeCowsInStalls = new ArrangeCowsInStalls();
        System.out.println(arrangeCowsInStalls.arrange(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 2)); // 10
        System.out.println(arrangeCowsInStalls.arrange(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 3)); // 5
        System.out.println(arrangeCowsInStalls.arrange(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 4)); // 3
        System.out.println(arrangeCowsInStalls.arrange(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5)); // 2
        System.out.println(arrangeCowsInStalls.arrange(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 6)); // 2
        System.out.println(arrangeCowsInStalls.arrange(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 7)); // 1
        System.out.println(arrangeCowsInStalls.arrange(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 8)); // 1
        System.out.println(arrangeCowsInStalls.arrange(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 9)); // 1
        System.out.println("==========");
        System.out.println(arrangeCowsInStalls.arrange(new int[]{1, 5, 7, 9, 12}, 2)); // 11
        System.out.println(arrangeCowsInStalls.arrange(new int[]{1, 5, 7, 9, 12}, 3)); // 5
        System.out.println(arrangeCowsInStalls.arrange(new int[]{1, 5, 7, 9, 12}, 4)); // 3
    }

}
