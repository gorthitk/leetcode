class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }

        int[] pCount = new int[26];
        for (char ch : p.toCharArray()) {
            pCount[ch - 'a']++;
        }

        int n = p.length();
        int[] sCount = new int[26];
        for (int i = 0; i < n; i++) {
            sCount[s.charAt(i) - 'a']++;
        }

        int start = 0;
        if (isAnagram(sCount, pCount)) {
            result.add(start);
        }

        for (int i = n; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            sCount[s.charAt(start) - 'a']--;
            char begin = s.charAt(start++);

            if (isAnagram(sCount, pCount)) {
                result.add(start);
            }
        }

        return result;
    }

    private boolean isAnagram(int[] c1, int[] c2) {
        for (int i = 0; i < 26; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }
}