/**
 * @author tgorthi
 * @since Jun 2020
 */
public class Solution
{
    public int rangeBitwiseAnd(int m, int n)
    {
        return n > m ? rangeBitwiseAnd(m / 2, n / 2) << 1 : m;
    }
}