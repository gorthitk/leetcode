class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = 0, countZeros = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                countZeros++;
            }

            while (countZeros > k) {
                if (nums[start] == 0) {
                    countZeros--;
                }
                start++;
            }

            result = Math.max(result, i - start + 1);
        }

        return result;
    }
}
