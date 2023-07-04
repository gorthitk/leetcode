import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        result.add(new ArrayList<>()); // null set.

        List<Integer> current = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(i, nums, current, result);
            current.remove(current.size() - 1);
        }

        return result;
    }

    private void backtrack(int idx, int[] nums, List<Integer> current, List<List<Integer>> result) {
        if (idx == nums.length) {
            return;
        }

        result.add(new ArrayList<>(current));


        for (int i = idx + 1; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(i, nums, current, result);
            current.remove(current.size() - 1);
        }
    }
}