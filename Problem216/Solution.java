

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public List<List<Integer>> combinationSum3(int k, int n)
    {
        List<List<Integer>> result = new ArrayList<>();
        getCombinations(n, 0, new ArrayList<>(), result, 1, k);
        return result;
    }

    private void getCombinations(int target, int currSum, List<Integer> curr, List<List<Integer>> result, int idx,
                                 int k)
    {
        if (currSum > target || curr.size() > k)
        {
            return;
        }
        if (currSum == target && curr.size() == k)
        {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = idx; i < 10; i++)
        {
            curr.add(i);
            getCombinations(target, currSum + i, curr, result, i + 1, k);
            curr.remove(curr.size() - 1);
        }
    }
}