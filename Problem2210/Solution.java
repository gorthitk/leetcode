class Solution {
    public int countHillValley(int[] nums) {
        int count = 0;

        int i = 1;
        while (i < nums.length && nums[i] == nums[i-1]) {
            i++;
        }

        int prev = i - 1;
        for (; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                continue;
            }

            if (nums[i] > nums[prev] && nums[i] > nums[i+1]) {
                count++;
            }

            if (nums[i] < nums[prev] && nums[i] < nums[i+1]) {
                count++;
            }

            prev = i;
        }

        return count;
    }
}