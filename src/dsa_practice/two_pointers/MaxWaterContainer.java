package dsa_practice.two_pointers;

public class MaxWaterContainer {
    public static int maxArea(int[] heights) {
        int maxArea = 0;
        int left = 0;
        int right = heights.length - 1;

        while(left < right) {
            int height = Math.min(heights[right],heights[left]);
            int width = right - left;
            int area = height * width;

            maxArea = Math.max(maxArea , area);

            if(heights[left] < heights[right]){
                left++;
            } else {
                right--;
            }

        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {3, 4, 1, 2, 2, 4, 1, 3, 2};
        int result = maxArea(heights);
        System.out.println("Maximum area of water that can be contained: " + result);
    }
}
