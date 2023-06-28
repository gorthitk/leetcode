class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }


        long min = Integer.MAX_VALUE;
        int res = -1;

        long prefixSum = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];


            long a = prefixSum / (i + 1);
            long b = i == n - 1 ? 0 : (sum - prefixSum) / (n - i - 1);

            long d = Math.abs(a - b);

            if (min > d) {
                min = d;
                res = i;
            }
        }

        return res;
    }
}