/**
 * @author tgorthi
 * @since Jun 2020
 */
public class Solution
{
    public int countNumbersWithUniqueDigits(int n)
    {
        if (n == 0)
        {
            return 0;
        }
        if (n == 1)
        {
            return 10;
        }
        if (n > 10)
        {
            return countNumbersWithUniqueDigits(10);
        }
        int count = 81;
        int remaining = n - 2;
        int options = 8;
        while (remaining > 0)
        {
            count *= options;
            options--;
            remaining--;
        }
        return count + countNumbersWithUniqueDigits(n - 1);
    }
}