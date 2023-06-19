
class Solution
{
    public int numberOfSubstrings(String s)
    {
        if (s == null || s.length() < 3)
        {
            return 0;
        }
        final char[] ss = s.toCharArray();
        final int n = ss.length;
        int result = 0;
        int i = 0, j = 0;
        final int[] counts = new int[3];
        while (i < n - 2)
        {
            while (j < n && !_containsAllCharacters(counts))
            {
                _updateCounts(counts, ss[j++], 1);
            }
            if (_containsAllCharacters(counts))
            {
                result += (n - j + 1);
            }
            else
            {
                break;
            }
            _updateCounts(counts, ss[i++], -1);
        }
        return result;
    }

    private boolean _containsAllCharacters(int[] counts)
    {
        return counts[0] > 0 && counts[1] > 0 && counts[2] > 0;
    }

    private void _updateCounts(int[] counts, char ch, int add)
    {
        if (ch == 'a')
        {
            counts[0] += add;
        }
        else if (ch == 'b')
        {
            counts[1] += add;
        }
        else if (ch == 'c')
        {
            counts[2] += add;
        }
    }
}