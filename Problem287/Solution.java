class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        boolean[] seen = new boolean[n];
        for (int i = 0; i < nums.length; i++) {
            if (seen[nums[i]]) {
                return nums[i];
            }
            seen[nums[i]] = true;
        }
        return 0;
    }
}