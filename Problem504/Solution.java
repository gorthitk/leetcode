/**
 * @author tgorthi
 * @since Jun 2020
 */
public class Solution
{
    public String convertToBase7(int num)
    {
        boolean neg = num < 0;
        num = Math.abs(num);
        StringBuilder sb = new StringBuilder();
        if (num == 0)
        {
            sb.append(0);
        }
        while (num > 0)
        {
            sb.append(num % 7);
            num /= 7;
        }
        return neg ? "-" + sb.reverse().toString() : sb.reverse().toString();
    }
}