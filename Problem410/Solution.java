class Solution {
    public int splitArray(int[] nums, int k) {

        int n = nums.length;
        Integer[][] memo = new Integer[1001][51];
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = nums[i - 1] + prefixSum[i - 1];
        }


        return recurse(0, nums, k, memo, prefixSum);
    }

    private int recurse(int idx, int[] nums, int subarrayCount, Integer[][] memo, int[] prefixSum) {
        int n = nums.length;
        if (memo[idx][subarrayCount] != null) {
            return memo[idx][subarrayCount];
        }

        if (subarrayCount == 1) {
            memo[idx][subarrayCount] = prefixSum[n] - prefixSum[idx];
            return memo[idx][subarrayCount];
        }


        int minSum = Integer.MAX_VALUE;

        for (int i = idx; i <= n - subarrayCount; i++) {
            int currSum = prefixSum[i + 1] - prefixSum[idx];
            int remain = recurse(i + 1, nums, subarrayCount - 1, memo, prefixSum);

            int maxSplitSum = Math.max(currSum, remain);

            minSum = Math.min(minSum, maxSplitSum);

            if (currSum >= minSum) {
                break;
            }
        }


        memo[idx][subarrayCount] = minSum;
        return minSum;
    }
}