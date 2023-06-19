import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(0, candidates, 0, target, new ArrayList<>(), result);
        return result;
    }


    private void backtrack(int start, int[] candidates, int sum, int target, List<Integer> current,
                           List<List<Integer>> result) {
        if (sum > target) {
            return;
        }

        if (sum == target) {
            result.add(new ArrayList<>(current));
            return;
        }


        for (int i = start; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                continue;
            }
            current.add(candidates[i]);
            backtrack(i, candidates, sum + candidates[i], target, current, result);
            current.remove(current.size() - 1);
        }
    }
}