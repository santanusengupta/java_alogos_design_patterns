package dsa_practice.two_pointers;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = {0,2,1,1,2,0,2,1,0};
        sortColors(nums);

        // Print sorted array
        System.out.print("Sorted colors: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static void sortColors(int[] nums) {
        int low=0;
        int mid=0;
        int high= nums.length - 1;

        while(mid < high){
            switch (nums[mid]){
                case 0:
                    swap(nums, low , mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(nums,mid,high);
                    high--;
                    break;
            }
        }
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


}
