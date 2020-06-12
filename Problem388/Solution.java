/**
 * @author tgorthi
 * @since Jun 2020
 */

import java.util.*;

public class Solution
{
    public int lengthLongestPath(String input)
    {
        String dirs[] = input.split("\n");
        int len = 0;
        int result = 0;
        Stack<String> stack = new Stack<>();
        for (String dir : dirs)
        {
            int level = dir.lastIndexOf("\t") + 1;
            dir = dir.replace("\t", "");
            while (stack.size() > level)
            {
                len = len - stack.pop().length() - 1;
            }
            len += dir.length() + 1;
            stack.push(dir);
            if (dir.contains("."))
            {
                result = Math.max(result, len - 1);
            }
        }
        return result;
    }
}