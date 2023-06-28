class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] jumps = new int[n];

        for (int i = n - 2; i >= 0; i--) {

            int min = Integer.MAX_VALUE;
            int maxJump = nums[i];

            while (maxJump > 0) {
                if (i + maxJump < n && jumps[i + maxJump] != Integer.MAX_VALUE) {
                    min = Math.min(min, 1 + jumps[i + maxJump]);
                }
                maxJump--;
            }

            jumps[i] = min;
        }


        return jumps[0];
    }
}