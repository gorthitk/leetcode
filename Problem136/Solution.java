
public class Solution
{
    public String longestCommonPrefix(String[] strs)
    {
        if (strs == null || strs.length == 0)
        {
            return "";
        }
        String first = strs[0];
        int len = first.length();
        int idx = first.length();
        for (int i = 1; i < strs.length; i++)
        {
            int j = 0;
            int k = 0;
            String str = strs[i];
            while (j < len && k < str.length() && str.charAt(k) == first.charAt(j))
            {
                j++;
                k++;
            }
            idx = Math.min(idx, j);
        }
        return strs[0].substring(0, idx);
    }
}