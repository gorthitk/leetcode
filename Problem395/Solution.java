public class Solution
{
    public int longestSubstring(String s, int k)
    {
        char[] str = s.toCharArray();
        return getSubstring(str, k, 0, s.length());
    }

    private int getSubstring(char[] s, int k, int start, int end)
    {
        if (end - start < k)
            return 0;
        int[] counts = new int[26];
        for (int i = start; i < end; i++)
        {
            counts[s[i] - 'a']++;
        }
        for (int i = 0; i < 26; i++)
        {
            int count = counts[i];
            if (count > 0 && count < k)
            {
                for (int idx = start; idx < end; idx++)
                {
                    if (s[idx] - 'a' == i)
                    {
                        int left = getSubstring(s, k, start, idx);
                        int right = getSubstring(s, k, idx + 1, end);
                        return Math.max(left, right);
                    }
                }

            }
        }
        return end - start;
    }
}