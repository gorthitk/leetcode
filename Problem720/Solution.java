import java.util.*;
import java.util.Arrays;

class Solution
{
    public String longestWord(String[] words)
    {
        String longestWord = "";
        Set<String> set = new HashSet();
        Arrays.sort(words);
        for (String word : words)
        {
            String subString = word.substring(0, word.length() - 1);
            if (word.length() == 0 || set.contains(subString))
            {
                set.add(word);
                if (longestWord.length() < word.length())
                {
                    longestWord = word;
                }
            }
        }

        return longestWord;
    }

}