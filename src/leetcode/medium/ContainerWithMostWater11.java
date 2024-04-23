package leetcode.medium;

public class ContainerWithMostWater11 {

    public int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int maxAmountOfWater = 0;
        while (leftIndex < rightIndex) {
            int amountOfWater = (rightIndex - leftIndex) * Math.min(height[leftIndex], height[rightIndex]);
            maxAmountOfWater = Math.max(maxAmountOfWater, amountOfWater);
            if (height[leftIndex] < height[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        return maxAmountOfWater;
    }

    public static void main(String[] args) {
        ContainerWithMostWater11 containerWithMostWater11 = new ContainerWithMostWater11();
        System.out.println(containerWithMostWater11.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // 49
        System.out.println(containerWithMostWater11.maxArea(new int[]{1, 1})); // 1
    }
}
