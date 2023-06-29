class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int n = nums.length;
        if (nums[n - 1] > nums[0]) {
            return nums[0];
        }

        int i = 0, j = n - 1;
        while (i <= j) {
            int mid = (j + i) / 2;

            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            if (nums[mid] > nums[0]) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return nums[i];
    }
}