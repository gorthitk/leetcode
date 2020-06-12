import java.util.HashMap;
import java.util.Map;

public class Solution
{
    public int findLHS(int[] nums)
    {
        Map<Integer, Integer> counts = new HashMap<>();
        int len = 0;
        for (int num : nums)
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        for (Integer key : counts.keySet())
        {
            if (counts.containsKey(key + 1))
                len = Math.max(len, counts.get(key) + counts.get(key + 1));
        }
        return len;
    }
}