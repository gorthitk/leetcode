import java.util.Stack;

public class Solution
{
    private static final String CDATA_START = "<![CDATA[";
    private static final String CDATA_END = "]]>";
    private static final String OPEN_TAG = "<";
    private static final String CLOSE_TAG = "</";
    private static final String END_TAG = ">";

    public boolean isValid(String code)
    {
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < code.length(); )
        {
            if (i > 0 && stack.isEmpty())
            {
                return false;
            }
            if (code.startsWith(CDATA_START, i))
            {
                int idx = code.indexOf(CDATA_END, i + CDATA_START.length() - 1);
                if (idx == -1)
                {
                    return false;
                }
                i = idx + CDATA_END.length();
            }
            else if (code.startsWith(CLOSE_TAG, i))
            {
                int idx = code.indexOf(END_TAG, i + CLOSE_TAG.length() - 1);
                if (idx == -1)
                    return false;
                String s = code.substring(i + CLOSE_TAG.length(), idx);
                if (stack.isEmpty() || !stack.pop().equals(s))
                {
                    return false;
                }
                i = idx + END_TAG.length();
            }
            else if (code.startsWith(OPEN_TAG, i))
            {
                int idx = code.indexOf(END_TAG, i + OPEN_TAG.length() - 1);
                if (idx == -1)
                {
                    return false;
                }
                String s = code.substring(i + OPEN_TAG.length(), idx);
                if (s.isEmpty() || s.length() < 1 || s.length() > 9)
                    return false;
                for (char c : s.toCharArray())
                {
                    if (!Character.isUpperCase(c))
                    {
                        return false;
                    }
                }
                stack.add(s);
                i = idx + END_TAG.length();
            }
            else
            {
                i++;
            }
        }
        return stack.isEmpty();
    }
}