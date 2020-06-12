/**
 * @author tgorthi
 * @since Jun 2020
 */
public class Solution
{
    public boolean canConstruct(String ransomNote, String magazine)
    {
        if (ransomNote == null || magazine == null)
        {
            return ransomNote == magazine;
        }
        int[] counts = new int[26];
        for (char c : ransomNote.toCharArray())
        {
            counts[c - 'a']++;
        }
        for (char c : magazine.toCharArray())
        {
            counts[c - 'a']--;
        }
        for (int i = 0; i < 26; i++)
        {
            if (counts[i] > 0)
            {
                return false;
            }
        }
        return true;
    }
}