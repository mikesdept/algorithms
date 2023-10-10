package algorithms.arrays;

public class ContainerWithMostWater {

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
        System.out.println(containerWithMostWater.getContainerWithMostWaterBruteForceSolution(new int[]{7, 1, 2, 3, 9}));
    }
}
