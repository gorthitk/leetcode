import java.util.HashSet;
import java.util.Set;

class Solution
{
    private static final String[] MORSE_CODE =
            {
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",
            ".---","-.-",".-..","--","-.","---",".--.","--.-", ".-.",
            "...","-","..-","...-",".--","-..-","-.--","--.."
            };

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> transformations = new HashSet<>();
        for (String word : words)
        {
            StringBuilder transformation = new StringBuilder();
            for (char chr : word.toLowerCase().toCharArray())
            {
                transformation.append(MORSE_CODE[chr - 'a']);
            }
            transformations.add(transformation.toString());
        }
        return transformations.size();
    }
}