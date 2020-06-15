/**
 * @author tgorthi
 * @since Jun 2020
 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution
{
    public boolean wordBreak(String s, List<String> wordDict)
    {
        final Set<String> words = new HashSet<>(wordDict);
        final int n = s.length();

        final boolean[] dp = new boolean[n];

        // dp[i] -> can be broken down if S[i..j] is in the dictionary and dp[j] = true;

        for (int i = n - 1; i >= 0; i--)
        {
            for (int j = i; j < n && !dp[i]; j++)
            {
                if (j == n - 1 || dp[j + 1])
                {
                    String subStr = s.substring(i, j + 1);
                    dp[i] = words.contains(subStr);
                }
            }
        }


        return dp[0];
    }
}