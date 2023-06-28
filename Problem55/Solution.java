class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] + i >= farthest) {
                farthest = i;
            }
        }

        return farthest == 0;
    }
}