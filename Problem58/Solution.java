/**
 * @author tgorthi
 * @since Jun 2020
 */
public class Solution
{
    public int lengthOfLastWord(String s)
    {
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }
}