
public class Solution
{
    public String reverseWords(String str)
    {
        if (str == null || str.length() == 0)
        {
            return str;
        }
        int n = str.length();
        StringBuilder reverse = new StringBuilder();
        StringBuilder reverseWord = new StringBuilder();
        for (int i = 0; i < n; i++)
        {
            if (str.charAt(i) != ' ')
            {
                reverseWord.append(str.charAt(i));
            }
            if ((str.charAt(i) == ' ') || (i == n - 1))
            {
                reverseWord = reverseWord.reverse();
                reverse.append(reverseWord);
                if (i != n - 1)
                {
                    reverse.append(" ");
                }
                reverseWord = new StringBuilder();
            }
        }
        return reverse.toString();
    }
}