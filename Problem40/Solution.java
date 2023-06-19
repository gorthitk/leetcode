

import java.util.*;

public class Solution
{
    public List<List<Integer>> combinationSum2(int[] candidates, int target)
    {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        getCombinations(candidates, 0, target, new ArrayList<Integer>(), result);
        return result;
    }

    private void getCombinations(int[] candidates, int curr, int target, ArrayList<Integer> path,
                                 List<List<Integer>> result)
    {
        if (target == 0)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        if (target < 0)
        {
            return;
        }
        for (int i = curr; i < candidates.length; i++)
        {
            if (i > curr && candidates[i] == candidates[i - 1])
            {
                continue;
            }
            path.add(candidates[i]);
            getCombinations(candidates, i + 1, target - candidates[i], path, result);
            path.remove(path.size() - 1);
        }
    }
}