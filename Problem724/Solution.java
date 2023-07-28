class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum -= nums[i];
            if (sum == totalSum) {
                return i;
            }

            sum += nums[i];
        }

        return -1;
    }
}
