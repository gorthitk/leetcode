class Solution {
    public int minOperations(int[] nums, int x) {

        int max = nums[0], totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            totalSum += nums[i];
        }

        int target = totalSum - x;
        if (target == 0) {
            return nums.length;
        }

        if (target == -1) {
            return -1;
        }

        int sum = 0;
        int start = 0;
        int len = -1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while (start < i && sum > target) {
                sum -= nums[start];
                start++;
            }

            if (sum == target) {
                len = Math.max(len, i - start + 1);
            }
        }

        return len > 0 ? nums.length - len : -1;
    }
}