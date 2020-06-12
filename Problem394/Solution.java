/**
 * @author tgorthi
 * @since Jun 2020
 */

import java.util.*;

public class Solution
{
    public String decodeString(String s)
    {
        Stack<String> words = new Stack<>();
        Stack<Integer> counts = new Stack<>();
        words.push("");
        int i = 0;
        while (i < s.length())
        {
            char c = s.charAt(i);
            if (Character.isDigit(c))
            {
                int end = i;
                while (Character.isDigit(s.charAt(end)))
                {
                    end++;
                }
                int count = Integer.parseInt(s.substring(i, end));
                counts.push(count);
                i = end - 1;
            }
            else if (c == '[')
            {
                words.push("");
            }
            else if (c == ']')
            {
                StringBuilder sb = new StringBuilder();
                int count = counts.pop();
                String str = words.pop();
                while (count > 0)
                {
                    sb.append(str);
                    count--;
                }
                words.push(words.pop() + sb.toString());
            }
            else
            {
                words.push(words.pop() + c);
            }
            i++;
        }
        return words.pop();
    }
}