import java.util.Stack;

public class Solution
{
    public int longestValidParentheses(String s)
    {
        Stack<int[]> stack = new Stack<>();
        int len = 0;
        for (int i = 0; i < s.length(); i++)
        {
            char current = s.charAt(i);
            if (current == '(')
            {
                stack.push(new int[] { i, 0 });
            }
            else
            {
                if (stack.isEmpty() || stack.peek()[1] == 1)
                {
                    stack.push(new int[] { i, 1 });
                }
                else
                {
                    stack.pop();
                    len = Math.max(len, stack.isEmpty() ? i + 1 : i - stack.peek()[0]);
                }
            }
        }
        return len;
    }
}