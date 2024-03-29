
/* * Find the length of the common subsequence * Since only delete operation possible, subtract the length of common
subsequence from sum of lengths of word1 and word2. */public class Solution
 */
{
    public int minDistance(String word1, String word2)
    {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1]; // Find Length of Common Subsequence        for
// (int i = 0; i <= word1.length(); i++)        {            for (int j = 0; j <= word2.length(); j++)            {
// dp[i][j] = i == 0 || j == 0 ? 0 : word1.charAt(i - 1) == word2.charAt(j - 1) ? 1 + dp[i - 1][j - 1] : Math.max
// (dp[i - 1][j], dp[i][j - 1]);            }        }        return word1.length() + word2.length() - 2 * dp[word1
// .length()][word2.length()];    }}