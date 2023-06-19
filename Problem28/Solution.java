
public class Solution
{
    public int strStr(String haystack, String needle)
    {
        if (haystack.equals(needle))
        {
            return 0;
        }
        for (int i = 0; i < haystack.length() - needle.length(); i++)
        {
            int k = i;
            int j = 0;
            while (j < needle.length() && k < haystack.length() && haystack.charAt(k) == needle.charAt(j))
            {
                k++;
                j++;
            }
            if (j == needle.length())
            {
                return i;
            }
        }
        return -1;
    }
}