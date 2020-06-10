import java.util.Arrays;
import java.util.Comparator;

class Solution
{
    private static final Comparator<String> COMPARATOR = Comparator.comparing(String::length);
    private static final String DELIMITER = " ";

    public String arrangeWords(String text)
    {
        final String[] words = text.split(DELIMITER);
        words[0] = words[0].toLowerCase();
        Arrays.sort(words, COMPARATOR);

        final StringBuilder result = new StringBuilder();

        final String firstWord = Character.toUpperCase(words[0].charAt(0)) + words[0].substring(1);
        result.append(firstWord);

        for (int i = 1; i < words.length; i++)
        {
            result.append(DELIMITER).append(words[i]);
        }

        return result.toString();
    }
}