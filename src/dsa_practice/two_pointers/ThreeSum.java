package dsa_practice.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    /*
    Given an input integer array nums, write a function to find all unique triplets [nums[i], nums[j], nums[k]]
    such that i, j, and k are distinct indices, and the sum of nums[i], nums[j], and nums[k] equals zero.
    Ensure that the resulting list does not contain any duplicate triplets.
     */
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> triplets = threeSum(nums);

        System.out.println("Unique triplets that sum to zero:");
        for (List<Integer> triplet : triplets) {
            System.out.println(triplet);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Iterate through the array, fixing one number at a time
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements for the first number
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1; // Pointer to the next element
            int right = nums.length - 1; // Pointer to the last element

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // Add the triplet to the result
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Move the left pointer to the next unique element
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Move the right pointer to the next unique element
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // Move both pointers inward
                    left++;
                    right--;
                } else if (sum < 0) {
                    // Increase the sum by moving the left pointer to the right
                    left++;
                } else {
                    // Decrease the sum by moving the right pointer to the left
                    right--;
                }
            }
        }

        return result;
    }
}
