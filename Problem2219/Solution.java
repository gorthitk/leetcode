class Solution {
    public long maximumSumScore(int[] nums) {
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }


        long max = Integer.MIN_VALUE;

        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, Math.max(sum, totalSum));
            totalSum -= nums[i];
        }


        return max;
    }
}