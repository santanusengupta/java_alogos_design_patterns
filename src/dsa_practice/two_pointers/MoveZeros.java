package dsa_practice.two_pointers;

import java.util.Arrays;

public class MoveZeros {

    /*
    Given an integer array nums, write a function to rearrange the array by moving all zeros to the end while
    keeping the order of non-zero elements unchanged. Perform this operation in-place without creating
    a copy of the array.
     */
    public static void main(String[] args) {
        int nums[] = {2,0,4,0,9};
        int moveZerotoLastIndex = 0;
        for(int i=0; i< nums.length;i++) {
            if(nums[i] !=0) {
                if(i != moveZerotoLastIndex){
                    int temp = nums[i];
                    nums[i] = nums[moveZerotoLastIndex];
                    nums[moveZerotoLastIndex] = temp;
                }
                moveZerotoLastIndex++;
            }
        }
        for(int num : nums){
            System.out.print(num + "  ");
        }
    }
}
