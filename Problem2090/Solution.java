class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i-1];
        }

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            if (i + k >= n || i - k < 0) {
                result[i] = -1;
                continue;
            }

            long subArraySum = prefixSum[i + k]
                    + nums[i + k] - prefixSum[i - k];
            int average = (int) (subArraySum / (2 * k + 1));
            result[i] = (int) average;
        }

        return result;
    }
}