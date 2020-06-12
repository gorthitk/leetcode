public class Solution
{
    public boolean isNumber(String s)
    {
        s = s.trim();
        int count_decimal = 0;
        int count_e = 0;
        int count_digit = 0;
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (!Character.isDigit(c))
            {
                if (c == '.')
                {
                    count_decimal++;
                    if (count_decimal > 1 || count_e != 0)
                    {
                        return false;
                    }
                }
                else if (c == 'e')
                {
                    count_e++;
                    if (count_e > 1 || count_digit == 0)
                    {
                        return false;
                    }
                    count_digit = 0;
                }
                else if (c == '-' || c == '+')
                {
                    if (i != 0 && s.charAt(i - 1) != 'e')
                    {
                        return false;
                    }
                }
                else
                {
                    return false;
                }
            }
            else
            {
                count_digit++;
            }
        }
        return count_digit > 0;
    }
}