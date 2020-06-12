/**
 * @author tgorthi
 * @since Jun 2020
 */

import java.util.Stack;

public class Solution
{
    public String simplifyPath(String path)
    {
        Stack<String> dirs = new Stack<>();
        for (String dir : path.split("/"))
        {
            if (dir.equals("..") && !dirs.isEmpty())
            {
                dirs.pop();
            }
            else
            {
                if (dir.equals(".") || dir.equals("..") || dir.equals(""))
                {
                    continue;
                }
                dirs.push(dir);
            }
        }
        String simplifiedPath = "";
        while (!dirs.isEmpty())
        {
            simplifiedPath = "/" + dirs.pop() + simplifiedPath;
        }
        return simplifiedPath.isEmpty() ? "/" : simplifiedPath;
    }
}