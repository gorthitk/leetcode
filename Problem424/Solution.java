class Solution {
    public int characterReplacement(String s, int k) {
        int result = 0;

        int[] counts = new int[26];
        int maxCount = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            counts[ch - 'A']++;
            maxCount = Math.max(maxCount, counts[ch - 'A']);
            int len = i - start + 1;
            if (len - maxCount > k) {
                char chStart = s.charAt(start);
                counts[chStart - 'A']--;
                start++;
            }

            result = Math.max(result, i - start + 1);
        }


        return result;
    }
}