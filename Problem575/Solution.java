

import java.util.*;

public class Solution
{
    public int distributeCandies(int[] candies)
    {
        int n = candies.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
        {
            int kind = candies[i];
            map.put(kind, map.getOrDefault(kind, 0) + 1);
        }
        int each = n / 2;
        return each >= map.size() ? map.size() : each;
    }
}