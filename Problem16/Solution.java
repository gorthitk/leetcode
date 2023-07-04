import java.util.*;

class Solution {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int closest = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return target;
                }

                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }

                if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return closest;
    }
}