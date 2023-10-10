package algorithms.arrays;

public class ContainerWithMostWater {

    public int getContainerWithMostWaterOptimalSolution(int[] array) {
        int max = 0;
        if (array == null || array.length < 2) {
            return max;
        }
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        while (leftIndex < rightIndex) {
            int maxCandidate = Math.min(array[leftIndex], array[rightIndex]) * (rightIndex - leftIndex);
            max = Math.max(max, maxCandidate);
            if (array[leftIndex] < array[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        return max;
    }

    public int getContainerWithMostWaterBruteForceSolution(int[] array) {
        int max = 0;
        if (array == null || array.length < 2) {
            return max;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int first = array[i];
                int second = array[j];
                int min;
                if (first <= second) {
                    min = first;
                } else {
                    min = second;
                }
                int square = min * (j - i);
                if (square > max) {
                    max = square;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println("brute force solution 1 -> " + containerWithMostWater.getContainerWithMostWaterBruteForceSolution(new int[]{7, 1, 2, 3, 9}));
        System.out.println("brute force solution 2 -> " + containerWithMostWater.getContainerWithMostWaterBruteForceSolution(new int[]{4, 8, 1, 2, 3, 9}));
        System.out.println("optimal solution 1 -> " + containerWithMostWater.getContainerWithMostWaterOptimalSolution(new int[]{7, 1, 2, 3, 9}));
        System.out.println("optimal solution 2 -> " + containerWithMostWater.getContainerWithMostWaterOptimalSolution(new int[]{4, 8, 1, 2, 3, 9}));
        System.out.println("optimal solution 3 -> " + containerWithMostWater.getContainerWithMostWaterOptimalSolution(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
