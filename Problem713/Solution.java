class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int start = 0, result = 0;
        long product = 1;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            while (product >= k) {
                product /= nums[start];
                start++;
            }

            result += i - start + 1;
        }

        return result;
    }
}