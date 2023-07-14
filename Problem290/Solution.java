class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] split = s.split(" ");
        if (pattern.length() != split.length) {
            return false;
        }

        Map<String, Integer> wordIdx = new HashMap<>();
        Map<Character, Integer> charIdx = new HashMap<>();
        int wordId = 1, charId = 1;
        for (int i = 0; i < pattern.length(); i++) {
            String w = split[i];
            char ch = pattern.charAt(i);

            if (!wordIdx.containsKey(w)) {
                wordIdx.put(w, wordId++);
            }

            if (!charIdx.containsKey(ch)) {
                charIdx.put(ch, charId++);
            }


            if (charIdx.get(ch) != wordIdx.get(w)) {
                return false;
            }
        }

        return true;
    }
}