
public class Solution
{
    public List<List<Integer>> subsetsWithDup(int[] nums)
    {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        getSubsets(nums, 0, result, new ArrayList<>());
        return result;
    }

    private void getSubsets(int[] nums, int idx, List<List<Integer>> result, ArrayList<Integer> current)
    {
        result.add(new ArrayList<>(current));
        for (int i = idx; i < nums.length; i++)
        {
            if (i > idx && nums[i] == nums[i - 1])
            {
                continue;
            }
            current.add(nums[i]);
            getSubsets(nums, i + 1, result, current);
            current.remove(current.size() - 1);
        }
    }
}