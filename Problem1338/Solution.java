

import java.util.HashMap;
import java.util.Map;

class Solution
{
    public int minSetSize(int[] arr)
    {
        final int n = arr.length;
        final Map<Integer, Integer> counts = new HashMap<>();
        for (int num : arr)
        {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        final int[] absCounter = new int[n + 1];
        for (int num : counts.keySet())
        {
            absCounter[counts.get(num)]++;
        }
        int setSize = 0;
        int newSize = 0;
        for (int i = n; i >= 0 && newSize < n / 2; i--)
        {
            int numberOfSets = absCounter[i];
            while (newSize < n / 2 && numberOfSets > 0)
            {
                setSize++;
                newSize += i;
                numberOfSets--;
            }
        }
        return setSize;
    }
}