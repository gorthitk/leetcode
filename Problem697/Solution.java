

import java.util.HashMap;
import java.util.Map;

class Solution
{
    public int findShortestSubArray(int[] nums)
    {
        final Map<Integer, Integer> startIdx = new HashMap<>(), endIdx = new HashMap<>(), counts = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            int num = nums[i];
            startIdx.putIfAbsent(num, i);
            endIdx.put(num, i);
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        int shortestLen = Integer.MAX_VALUE, max = 0;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet())
        {
            if (max <= entry.getValue())
            {
                int len = endIdx.get(entry.getKey()) - startIdx.get(entry.getKey()) + 1;
                shortestLen = max != entry.getValue() ? len : Math.min(shortestLen, len);
                max = entry.getValue();
            }
        }
        return shortestLen;
    }
}