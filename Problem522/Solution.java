

import java.util.Arrays;
import java.util.Comparator;

public class Solution
{
    public int findLUSlength(String[] strs)
    {
        int count = -1;
        Arrays.sort(strs, new Comparator<String>()
        {
            @Override
            public int compare(String a, String b)
            {
                return a.length() - b.length();
            }
        });
        for (int i = strs.length - 1; i >= 0; i--)
        {
            boolean isCommonSuqsequence = false;
            for (int j = strs.length - 1; j >= 0; j--)
            {
                isCommonSuqsequence = i == j ? isCommonSuqsequence : isSubSequence(strs[i], strs[j]);
                if (isCommonSuqsequence)
                {
                    break;
                }
            }
            if (!isCommonSuqsequence)
            {
                count = Math.max(count, strs[i].length());
            }
        }
        return count;
    }

    private boolean isSubSequence(String subSequence, String b)
    {
        if (subSequence.length() > b.length())
        {
            return false;
        }
        if (subSequence.equals(b))
        {
            return true;
        }
        int prevIdx = -1;
        for (int i = 0; i < subSequence.length(); i++)
        {
            char c = subSequence.charAt(i);
            int idx = b.indexOf(c, prevIdx + 1);
            if (idx == -1)
            {
                return false;
            }
            prevIdx = idx;
        }
        return true;
    }
}