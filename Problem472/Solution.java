

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution
{
    public List<String> findAllConcatenatedWordsInADict(String[] words)
    {
        List<String> result = new ArrayList<>();
        Arrays.sort(words, new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                return o1.length() - o2.length();
            }
        });
        Set<String> dictionary = new HashSet<>();
        for (int i = 0; i < words.length; i++)
        {
            if (isConcatenatedWord(words[i], dictionary))
            {
                result.add(words[i]);
            }
            dictionary.add(words[i]);
        }
        return result;
    }

    private boolean isConcatenatedWord(String word, Set<String> dictionary)
    {
        if (dictionary.isEmpty())
        {
            return false;
        }
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= word.length(); i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (!dp[j])
                {
                    continue;
                }
                if (dictionary.contains(word.substring(j, i)))
                {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }
}