/**
 * @author tgorthi
 * @since Jun 2020
 */

import java.util.ArrayList;
import java.util.List;

class Solution
{
    public List<String> printVertically(String s)
    {
        String[] words = s.split(" ");
        int maxLen = 0;
        for (String word : words)
        {
            maxLen = Math.max(maxLen, word.length());
        }
        final List<String> result = new ArrayList<>();
        for (int i = 0; i < maxLen; i++)
        {
            StringBuilder sb = new StringBuilder();
            for (String word : words)
            {
                if (i >= word.length())
                {
                    sb.append(" ");
                }
                else
                {
                    sb.append(word.charAt(i));
                }
            }
            int j = words.length - 1;
            while (sb.charAt(j) == ' ')
            {
                sb.deleteCharAt(j--);
            }
            result.add(sb.toString());
        }
        return result;
    }
}