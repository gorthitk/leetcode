class Solution {
    public boolean isMonotonic(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }

        int isIncreasing = 0;
        for (int i = 1; i < nums.length; i++) {
            int d = nums[i] - nums[i - 1];

            if (isIncreasing == 0 && d != 0) {
                isIncreasing = d > 0 ? 1 : -1;
            }

            if (isIncreasing == 1 && d < 0) {
                return false;
            }

            if (isIncreasing == -1 && d > 0) {
                return false;
            }
        }

        return true;
    }
}