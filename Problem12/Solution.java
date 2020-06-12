public class Solution
{
    private int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    private String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

    public String intToRoman(int num)
    {
        String res = "";
        int idx = 0;
        while (num > 0)
        {
            int k = num / values[idx];
            while (k > 0)
            {
                res = res + symbols[idx];
                k--;
            }
            num %= values[idx++];
        }
        return res;
    }
}