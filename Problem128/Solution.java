import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int max = 1;
        int len = 1;
        int previous = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num == previous) {
                continue;
            }

            if (num == previous + 1) {
                len++;
            } else {
                max = Math.max(len, max);
                len = 1;
            }
            previous = num;
        }

        max = Math.max(len, max);


        return max;
    }
}