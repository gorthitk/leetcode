import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        if (n == 0) {
            result.add(List.of(lower, upper));
            return result;
        }


        if (lower < nums[0]) {
            result.add(List.of(lower, nums[0] - 1));
        }


        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i-1] == 1) {
                continue;
            }

            result.add(List.of(nums[i-1] + 1, nums[i] - 1));
        }

        if (upper > nums[n - 1]) {
            result.add(List.of(nums[n - 1] + 1, upper));
        }


        return result;

    }
}