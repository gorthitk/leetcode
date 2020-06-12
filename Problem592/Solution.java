/**
 * @author tgorthi
 * @since Jun 2020
 */

import java.util.*;

public class Solution
{
    public String fractionAddition(String expression)
    {
        if (expression == null || expression.length() < 3)
        {
            return "";
        }
        List<Integer> numerators = new ArrayList<>();
        List<Integer> denominators = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++)
        {
            if (expression.charAt(i) == '/')
            {
                int denominator = 0;
                int j = i + 1;
                while (j < expression.length() && Character.isDigit(expression.charAt(j)))
                {
                    denominator = denominator * 10 + expression.charAt(j) - '0';
                    j++;
                }
                j = i - 1;
                int numerator = 0;
                StringBuilder num = new StringBuilder();
                while (j >= 0 && Character.isDigit(expression.charAt(j)))
                {
                    num.append("" + expression.charAt(j));
                    j--;
                }
                num.reverse();
                numerator = Integer.parseInt(num.toString());
                if (j >= 0)
                {
                    if (expression.charAt(j) == '-')
                    {
                        numerator *= -1;
                    }
                }
                numerators.add(numerator);
                denominators.add(denominator);
            }
        }
        long result_denominator = getLCM(denominators);
        long result_numerator = 0;
        for (int i = 0; i < numerators.size(); i++)
        {
            result_numerator += numerators.get(i) * (result_denominator / denominators.get(i));
        }
        long gcd = getGCD(Math.abs(result_numerator), result_denominator);
        result_denominator = result_denominator / gcd;
        result_numerator = result_numerator / gcd;
        return "" + result_numerator + "/" + result_denominator;
    }

    private long getLCM(List<Integer> denominators)
    {
        long lcm = denominators.get(0);
        for (int i = 1; i < denominators.size(); i++)
        {
            lcm = getLCM(lcm, denominators.get(i));
        }
        return lcm;
    }

    private long getGCD(long a, long b)
    {
        while (b > 0)
        {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private long getLCM(long a, long b)
    {
        return a * (b / getGCD(a, b));
    }
}