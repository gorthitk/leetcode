class Solution {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {

        int n = nums.length;
        int[] leftSum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            leftSum[i] = nums[i - 1] + leftSum[i - 1];
        }


        int[] subArraySum = new int[n];

        for (int i = 0; i < n; i++) {
            if (i + k <= n) {
                subArraySum[i] = leftSum[i + k] - leftSum[i];
            }
        }


        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        int lMax = 0;
        for (int i = 0; i < n; i++) {
            if (subArraySum[i] > subArraySum[lMax]) {
                lMax = i;
            }

            leftMax[i] = lMax;
        }

        int rMax = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (subArraySum[i] >= subArraySum[rMax]) { // equality for lexicographically smallest.
                rMax = i;
            }

            rightMax[i] = rMax;
        }


        int max = 0;
        int[] result = null;
        for (int i = 0; i < n; i++) {
            if (i - k < 0 || i + k >= n) {
                continue;
            }
            int left = leftMax[i - k];
            int right = rightMax[i + k];

            int sum = subArraySum[i]+ subArraySum[left] + subArraySum[right];

            if (sum > max) {
                max = sum;
                result = new int[] {left, i, right};
            }

        }
        return result;
    }
}