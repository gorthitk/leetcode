/**
 * @author tgorthi
 * @since Jun 2020
 */
public class Solution
{
    public String convertToTitle(int n)
    {
        return n == 0 ? "" : convertToTitle(--n / 26) + (char) ('A' + n % 26);
    }
}