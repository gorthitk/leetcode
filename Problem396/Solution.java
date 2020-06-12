/**
 * @author tgorthi
 * @since Jun 2020
 */
public class Solution
{
    public int maxRotateFunction(int[] A)
    {
        int sum = 0;
        int F = 0;
        for (int i = 0; i < A.length; i++)
        {
            int num = A[i];
            F += i * num;
            sum += num;
        }        // DP : F(n) = F(n-1) + sum - n*bk[0];        int max = F;        int len = A.length;        for
        // (int i = 0; i < len; i++)        {            F = F + sum - len * A[i];            max = Math.max(F, max);
        // }        return max;    }}