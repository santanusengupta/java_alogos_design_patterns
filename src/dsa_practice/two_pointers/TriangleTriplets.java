package dsa_practice.two_pointers;

import java.util.Arrays;

public class TriangleTriplets {
    public static void main(String[] args) {
        int[] nums = {11, 4, 9, 6, 15, 18};
        int result = countTriangleTriplets(nums);
        System.out.println("Number of triplets that can form triangles: " + result);
    }

    private static int countTriangleTriplets(int[] nums) {
        if(nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);
        int count = 0;
        int n = nums.length;

        for(int k = n -1; k >= 2; k--){
            int left = 0;
            int right = k - 1;

            while (left < right) {
                if(nums[left] + nums[right] > nums[k]) {
                    count +=(right - left);
                    right --;
                } else {
                    left++;
                }
            }

        }

        return count;

    }

}
