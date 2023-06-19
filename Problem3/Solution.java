import java.util.HashMap;
import java.util.Map;


class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int start = 0;
        Map<Character, Integer> seen = new HashMap<>();

        char[] arr = s.toCharArray();
        int max = 1;

        for (int i = 0; i < arr.length; i++) {
            char chr = arr[i];
            if (seen.containsKey(chr) && seen.get(chr) >= start) {
                max = Math.max(max, i - start);
                start = seen.get(chr) + 1;
            } else {
                max = Math.max(max, i - start + 1);
            }

            seen.put(chr, i);
        }

        return max;
    }
}