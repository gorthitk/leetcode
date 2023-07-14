class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int n = s.length(), m = t.length();
        // Differ by more than one char.
        if (n > m + 1 || m > n + 1) {
            return false;
        }

        // if eqaul they dont differ.
        if (s.equals(t)) {
            return false;
        }

        // if one of the string is empty.
        if (n == 0 || m == 0) {
            return true;
        }

        int i = 0, j = 0, mismatches = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
                continue;
            }

            mismatches++;
            if (n == m) {
                // If string lens are equal, then replace.
                i++;
                j++;
            } else if (n > m) {
                // Delete from s.
                i++;
            } else {
                // insert in s.
                j++;
            }

            if (mismatches > 1) {
                return false;
            }
        }

        return true;
    }
}