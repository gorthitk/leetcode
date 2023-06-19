
public class Solution
{
    public boolean checkInclusion(String s1, String s2)
    {
        int[] map = new int[256];
        for (Character ch : s1.toCharArray())
        {
            map[ch]++;
        }
        int start = 0;
        int end = 0;
        int count = s1.length();
        while (end < s2.length())
        {
            char ch = s2.charAt(end);
            end++;
            if (map[ch] > 0)
            {
                count--;
            }
            map[ch]--;
            if (count == 0)
            {
                return true;
            }
            if (end - start == s1.length())
            {
                ch = s2.charAt(start);
                start++;
                if (map[ch] >= 0)
                {
                    count++;
                }
                map[ch]++;
            }
        }
        return false;
    }
}