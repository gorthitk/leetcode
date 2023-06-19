

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution
{
    public String fractionToDecimal(int num, int deno)
    {
        if (num == 0)
        {
            return "0";
        }
        StringBuilder fraction = new StringBuilder();
        fraction.append(num > 0 ^ deno > 0 ? "-" : "");
        long numerator = Math.abs((long) num);
        long denominator = Math.abs((long) deno);
        fraction.append(numerator / denominator);
        numerator = (numerator % denominator) * 10;
        if (numerator == 0)
        {
            return fraction.toString();
        }
        fraction.append(".");
        Map<Long, Long> decimals = new LinkedHashMap<Long, Long>();
        while (numerator != 0)
        {
            long decimal = numerator / denominator;
            if (decimals.containsKey(numerator))
            {
                break;
            }
            decimals.put(numerator, decimal);
            numerator = (numerator % denominator) * 10;
        }
        boolean recurring = false;
        for (Long key : decimals.keySet())
        {
            if (key == numerator)
            {
                fraction.append("(");
                recurring = true;
            }
            fraction.append(decimals.get(key));
        }
        if (recurring)
        {
            fraction.append(")");
        }
        return fraction.toString();
    }
}