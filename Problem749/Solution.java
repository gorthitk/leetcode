

import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.stream.IntStream;

class Solution
{    /*Counts the number of occurrences of alphabets in a string*/
    private static BiConsumer<String, int[]> COUNTER =
            (w, counts) -> w.chars().mapToObj(i -> (char) i).filter(Character::isAlphabetic).map(Character::toLowerCase).forEach(c -> counts[c - 'a']++);    /*Checks if the counts of alphabets in a word are suffice to construct the license plate string*/
    private static BiPredicate<int[], int[]> MATCHER =
            (counts, charCounts) -> IntStream.range(0, 26).noneMatch(i -> counts[i] > charCounts[i]);

    public String shortestCompletingWord(String licensePlate, String[] words)
    {
        int[] counts = new int[26];
        COUNTER.accept(licensePlate, counts);
        String shortestWord = null;
        int shortestLen = Integer.MAX_VALUE;
        for (String word : words)
        {            /*Consider only first occurrence of the shortest string*/
            if (word.length() >= shortestLen)
            {
                continue;
            }
            int[] charCounts = new int[26];
            COUNTER.accept(word, charCounts);
            if (MATCHER.test(counts, charCounts))
            {
                shortestLen = word.length();
                shortestWord = word;
            }
        }
        return shortestWord;
    }
}