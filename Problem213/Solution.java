class Solution {
    public int rob(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }

        int n = nums.length;

        int m1 = max(nums, 0, n - 2);
        int m2 = max(nums, 1, n - 1);


        return Math.max(m1, m2);
    }


    private int max(int[] nums, int start, int end) {
        int[] dp = new int[nums.length - 1];

        int k = 0;
        for (int i = start; i <= end; i++) {
            dp[k] = Math.max(
                    (k - 1 >= 0 ? dp[k - 1] : 0),
                    (k - 2 >= 0 ? dp[k - 2] : 0) + nums[i]
            );
            k++;
        }

        return dp[nums.length - 2];
    }
}