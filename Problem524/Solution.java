

import java.util.Collections;
import java.util.List;

public class Solution
{
    public String findLongestWord(String s, List<String> d)
    {
        Collections.sort(d, (a, b) -> a.length() != b.length() ? b.length() - a.length() : a.compareTo(b));
        for (String wrd : d)
        {
            if (isSubstring(s, wrd))
            {
                return wrd;
            }
        }
        return "";
    }

    private boolean isSubstring(String s, String d)
    {
        if (s.length() < d.length())
        {
            return false;
        }
        int i = 0, j = 0;
        while (i < s.length() && j < d.length())
        {
            if (s.charAt(i) == d.charAt(j))
            {
                j++;
            }
            i++;
        }
        return j == d.length();
    }
}