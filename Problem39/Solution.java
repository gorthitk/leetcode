/**
 * @author tgorthi
 * @since Jun 2020
 */

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        List<List<Integer>> result = new ArrayList<>();
        getCombinations(candidates, target, 0, new ArrayList<>(), result, 0);
        return result;
    }

    private void getCombinations(int[] candidates, int target, int currSum, List<Integer> curr,
                                 List<List<Integer>> result, int idx)
    {
        if (currSum == target)
        {
            result.add(new ArrayList<>(curr));
            return;
        }
        if (currSum > target)
        {
            return;
        }
        for (int i = idx; i < candidates.length; i++)
        {
            curr.add(candidates[i]);
            getCombinations(candidates, target, currSum + candidates[i], curr, result, i);
            curr.remove(curr.size() - 1);
        }
    }
}