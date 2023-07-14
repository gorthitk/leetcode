class Solution {
    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        int expectedCount = nums[n - 1] - nums[0] + 1;
        int missingCount = expectedCount - n;
        if (k > missingCount) {
            return nums[n - 1] + k - missingCount;
        }

        for (int i = 1; i < n && k > 0; i++) {
            int d = nums[i] - nums[i - 1];
            if (d == 1) {
                continue;
            }

            int sub = Math.min(k, d - 1);
            k -= sub;

            if (k == 0) {
                return nums[i - 1] + sub;
            }
        }


        return nums[n - 1] + k;
    }
}