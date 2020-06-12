import java.util.HashMap;
import java.util.Map;

public class Solution
{

    public int[] twoSum(int[] nums, int target)
    {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++)
        {
            int num = nums[i];
            int find = target - num;
            if (map.containsKey(find))
            {
                result[0] = i;
                result[1] = map.get(find);
                break;
            }
            map.put(num, i);
        }

        return result;
    }

}