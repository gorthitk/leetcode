
class Solution
{
    public int maxVowels(String s, int k)
    {
        final char[] ss = s.toCharArray();
        int max = 0;
        int current = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++)
        {
            current += _getVowelCount(ss, i);
            if (i - start + 1 == k)
            {
                max = Math.max(max, current);
                current -= _getVowelCount(ss, start++);
            }
        }
        return max;
    }

    private int _getVowelCount(char[] ss, int index)
    {
        char ch = ss[index];
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
        {
            return 1;
        }
        return 0;
    }
}