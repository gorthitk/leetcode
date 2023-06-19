

import java.util.HashMap;
import java.util.Map;

class Solution
{
    int MOD = 1000000007;

    public static void main(String args[])
    {
        Solution sol = new Solution();
        System.out.println(sol.numWays(27, 7));
    }

    public int numWays(int steps, int arrLen)
    {
        Map<Integer, Map<Integer, Long>> cache = new HashMap<>();
        return numWays(0, steps, arrLen, cache);
    }

    private int numWays(final int currPos, final int steps, final int arrLen, Map<Integer, Map<Integer, Long>> cache)
    {
        if (steps == 0)
        {
            return currPos == 0 ? 1 : 0;
        }
        if (currPos > arrLen - 1 || currPos < 0)
        {
            return 0;
        }
        if (cache.containsKey(currPos) && cache.get(currPos).containsKey(steps))
        {
            return (int) (cache.get(currPos).get(steps) % MOD);
        }
        long count = 0;
        for (int j : new int[]{1, 0, -1})
        {
            if (j == 1 && (currPos + 1 > arrLen - 1))
            {
                continue;
            }
            if (j == -1 && (currPos - 1 < 0))
            {
                continue;
            }
            count += numWays(currPos + j, steps - 1, arrLen, cache);
        }
        cache.computeIfAbsent(currPos, HashMap::new).put(steps, count);
        return (int) (count % MOD);
    }
}