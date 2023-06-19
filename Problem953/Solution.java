class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] ranks = new int[26];

        for (int i = 0; i < order.length(); i++) {
            ranks[order.charAt(i) -'a'] = i;
        }


        for (int i = 1; i < words.length; i++) {
            if (!isValid(words[i], words[i-1], ranks)) {
                return false;
            }
        }

        return true;
    }


    private static boolean isValid(String next, String previous, int[] ranks) {
        int p = previous.length(), n = next.length();
        int i = 0, j = 0;

        while (i < n && j < p) {
            int nRank = ranks[next.charAt(i++) - 'a'];
            int pRank = ranks[previous.charAt(j++) - 'a'];

            if (nRank > pRank) {
                return true;
            }

            if (nRank < pRank) {
                return false;
            }
        }


        return j == p;
    }
}