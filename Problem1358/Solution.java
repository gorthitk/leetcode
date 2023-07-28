class Solution {
    public int numberOfSubstrings(String s) {

        int[] count = new int[3];
        int n = s.length();
        int end = 0;

        int result = 0;

        for (int i = 0; i < n; i++) {
            while (end < n && (count[0] == 0 || count[1] == 0 || count[2] == 0)) {
                count[s.charAt(end) - 'a']++;
                end++;
            }

            if (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                result += n - end + 1;
            }

            count[s.charAt(i) - 'a']--;
        }

        return result;
    }
}