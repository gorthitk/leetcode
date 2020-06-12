/**
 * @author tgorthi
 * @since Jun 2020
 */
public class Solution
{
    public String getHint(String secret, String guess)
    {
        int len = secret.length();
        int[] counts1 = new int[10];
        int[] counts2 = new int[10];
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < len; i++)
        {
            int c1 = secret.charAt(i) - '0';
            int c2 = guess.charAt(i) - '0';
            if (c1 == c2)
            {
                bulls++;
            }
            else
            {
                counts1[c1]++;
                counts2[c2]++;
            }
        }
        for (int i = 0; i < 10; i++)
        {
            cows += Math.min(counts1[i], counts2[i]);
        }
        return "" + bulls + 'A' + cows + 'B';
    }
}