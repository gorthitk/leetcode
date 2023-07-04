import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            seen.add(num);
        }

        int max = 0;
        // Time O(n)
        // Space O(n)
        for (int num : seen) {
            if (!seen.contains(num - 1)) {
                int len = 1;
                int curr = num;
                while (seen.contains(curr + 1)) {
                    len++;
                    curr++;
                }
                max = Math.max(len, max);
            }
        }

        return max;
    }
}