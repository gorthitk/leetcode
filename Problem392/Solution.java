
public class Solution
{
    public boolean isSubsequence(String s, String t)
    {
        if (s.length() > t.length())
        {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < s.length())
        {
            while (j < t.length() && t.charAt(j) != s.charAt(i))
            {
                j++;
            }
            if (j >= t.length())
            {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}