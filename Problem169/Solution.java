class Solution {
    public int majorityElement(int[] nums) {
        int result = nums[0];
        int count = 0;
        for (int n : nums) {
            if (count == 0) {
                result = n;
            }

            count += n == result ? 1 : -1;
        }

        return result;
    }
}