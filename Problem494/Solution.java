class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        Integer[][] memo = new Integer[nums.length][2 * sum + 1];
        return backtrack(0, nums, 0, target, memo, sum);
    }


    private int backtrack(int idx, int[] nums, int sum, int target,  Integer[][] memo, int total) {
        if (idx == nums.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }


        if (memo[idx][sum + total] != null) {
            return memo[idx][sum + total];
        }


        int sub = backtrack(idx + 1, nums, sum - nums[idx], target, memo, total);
        int add = backtrack(idx + 1, nums, sum + nums[idx], target, memo, total);


        memo[idx][sum + total] = sub + add;

        return memo[idx][sum + total];
    }
}