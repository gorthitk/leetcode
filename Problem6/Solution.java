public class Solution
{
    public String convert(String s, int numRows)
    {
        if (numRows <= 1)
            return s;
        StringBuilder[] sbArr = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++)
        {
            sbArr[i] = new StringBuilder("");
        }
        int idx = 0;
        int incr = 1;
        int n = s.length();
        for (int i = 0; i < n; i++)
        {
            sbArr[idx].append(s.charAt(i));
            if (idx == 0)
                incr = 1;
            if (idx == numRows - 1)
                incr = -1;
            idx += incr;
        }
        String result = "";
        for (StringBuilder sb : sbArr)
        {
            result += sb;
        }
        return result;
    }
}