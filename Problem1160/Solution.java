class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] counter = new int[26];
        for (char ch : chars.toCharArray()) {
            counter[ch - 'a']++;
        }

        int count = 0;
        for (String word : words) {
            count += word.length();
            int[] copy = Arrays.copyOf(counter, 26);
            for (char ch : word.toCharArray()) {
                copy[ch - 'a']--;

                if (copy[ch - 'a'] < 0) {
                    count -= word.length();
                    break;
                }
            }
        }

        return count;
    }
}