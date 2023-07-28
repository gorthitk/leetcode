class Solution {
    public int waysToSplitArray(int[] nums) {
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }


        long sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int num = nums[i];
            sum += num;
            if (2 * sum >= totalSum) {
                count++;
            }
        }

        return count;
    }
}