/**
 * @author tgorthi
 * @since Jun 2020
 */
public class Solution
{
    public int myAtoi(String str)
    {
        if (str == null || str.length() == 0)
        {
            return 0;
        }
        int index = 0;
        str = str.trim();
        int n = str.length();
        boolean negativeNum = false;
        if (str.charAt(index) == '+' || str.charAt(index) == '-')
        {
            negativeNum = str.charAt(index) == '-' ? true : false;
            index++;
        }
        int result = 0;
        while (index < n)
        {
            int ch = str.charAt(index) - '0';
            if (ch > 9 || ch < 0)
            {
                break;
            }
            if (result > Integer.MAX_VALUE / 10 || Integer.MAX_VALUE / 10 == result && Integer.MAX_VALUE % 10 < ch)
            {
                return negativeNum == true ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result * 10 + ch;
            index++;
        }
        return negativeNum == true ? result * -1 : result;
    }
}