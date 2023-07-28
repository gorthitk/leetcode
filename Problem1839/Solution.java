import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestBeautifulSubstring(String word) {
        int count = 0;
        int max = 0;
        Set<Character> seen = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (i == 0 || ch >= word.charAt(i - 1)) {
                seen.add(ch);
                count++;
            } else {
                if (seen.size() == 5) {
                    max = Math.max(max, count);
                }

                count = 1;
                seen.clear();
                seen.add(ch);
            }
        }

        if (seen.size() == 5) {
            max = Math.max(max, count);
        }

        return max;
    }
}