/**
 * @author tgorthi
 * @since Jun 2020
 */

import java.util.*;

public class Solution
{
    public String getPermutation(int n, int k)
    {
        int[] fact = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++)
        {
            fact[i] = i * fact[i - 1];
        }
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++)
        {
            numbers.add(i);
        }
        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++)
        {
            int index = k / fact[n - i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k -= index * fact[n - i];
        }
        return String.valueOf(sb);
    }
}