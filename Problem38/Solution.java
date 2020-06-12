public class Solution
{
    public String countAndSay(int n)
    {
        if (n == 1)
            return "1";
        String prev = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        char c = prev.charAt(0);
        int count = 1;
        for (int i = 1; i < prev.length(); i++)
        {
            char current = prev.charAt(i);
            if (current == c)
            {
                count++;
            }
            else
            {
                sb.append(count);
                sb.append(c);
                c = current;
                count = 1;
            }
        }
        sb.append(count);
        sb.append(c);
        return sb.toString();
    }
}