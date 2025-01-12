package dsa_practice.two_pointers;

public class TrappingRainWater {
    public static void main(String[] args) {
        // Example input
        int[] height = {3, 4, 1, 2, 2, 5, 1, 0, 2};
        System.out.println("Total water trapped: " + trap(height)); // Output: 6
    }

    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0; // Pointer to traverse from the left
        int right = height.length - 1; // Pointer to traverse from the right
        int leftMax = 0; // Max height encountered from the left
        int rightMax = 0; // Max height encountered from the right
        int totalWater = 0; // Total water trapped

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // Update the left max height
                } else {
                    totalWater += leftMax - height[left]; // Add water trapped at the current position
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // Update the right max height
                } else {
                    totalWater += rightMax - height[right]; // Add water trapped at the current position
                }
                right--;
            }
        }

        return totalWater;
    }
}
