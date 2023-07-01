class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0;
        int len = 1;

        for (int i = 1; i <= nums.length; i++) {
            if (i == nums.length) {
                len = Math.max(len, i - start);
                break;
            }
            if (nums[i] <= nums[i - 1]) {
                len = Math.max(len, i - start);
                start = i;
            }
        }

        return len;
    }
}