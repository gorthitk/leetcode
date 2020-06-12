/**
 * @author tgorthi
 * @since Jun 2020
 */

import java.util.Stack;

public class MinStack
{
    private Stack<Integer> stack;
    private int min;

    /**
     * initialize your data structure here.
     */
    public MinStack()
    {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x)
    {
        min = Math.min(min, x);
        stack.push(x);
    }

    public void pop()
    {
        int top = this.top();
        Stack<Integer> local = new Stack<>();
        stack.pop();
        if (top == min)
        {
            min = Integer.MAX_VALUE;
            while (!stack.isEmpty())
            {
                int curr = stack.pop();
                min = Math.min(min, curr);
                local.push(curr);
            }
            while (!local.isEmpty())
            {
                stack.add(local.pop());
            }
        }
    }

    public int top()
    {
        return stack.peek();
    }

    public int getMin()
    {
        return min;
    }
}