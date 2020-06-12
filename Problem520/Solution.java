/**
 * @author tgorthi
 * @since Jun 2020
 */

import java.util.regex.Pattern;

public class Solution
{
    public boolean detectCapitalUse(String word)
    {
        return Pattern.compile("[A-Z]+").matcher(word).matches() || Pattern.compile("[a-z]+").matcher(word).matches() || Pattern.compile("[A-Z][a-z]+").matcher(word).matches();
    }
}