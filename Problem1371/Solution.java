class Solution
{
    public int findTheLongestSubstring(String s)
    {
        final int n = s.length();
        final char[] ss = s.toCharArray();
        final int[][] count = new int[n][5];

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < 5 && i > 0; j++)
            {
                count[i][j] = count[i - 1][j];
            }

            int index = _getVowelIndex(ss[i]);
            if (index >= 0)
            {
                count[i][index]++;
            }
        }

        for (int i = n; i > 0; i--)
        {
            for (int j = 0; j < n && i + j - 1 < n; j++)
            {
                if (_isEven(j, i + j - 1, count))
                {
                    return i;
                }
            }
        }

        return 0;
    }

    private boolean _isEven(int start, int end, final int[][] count)
    {
        for (int i = 0; i < 5; i++)
        {
            int charCount = count[end][i] - (start > 0 ? count[start - 1][i] : 0);

            if (charCount % 2 != 0)
            {
                return false;
            }
        }

        return true;
    }

    private int _getVowelIndex(char ssChar)
    {
        switch (ssChar)
        {
        case 'a':
            return 0;
        case 'e':
            return 1;
        case 'i':
            return 2;
        case 'o':
            return 3;
        case 'u':
            return 4;
        default:
            return -1;
        }
    }
}