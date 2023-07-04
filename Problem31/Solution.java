class Solution {
    public void nextPermutation(int[] nums) {
        // find the number that needs to replaced.
        int n = nums.length;
        int i = n - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }

        if (i >= 0) {
            int j = n - 1;
            // find the first number smaller than the current number.
            while (nums[j] <= nums[i]) {
                j--;
            }

            swap(nums, i, j);
        }

        reverse(nums, i + 1);
    }

    private static void reverse(int[] nums, int begin) {
        int i = begin, j = nums.length - 1;
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}