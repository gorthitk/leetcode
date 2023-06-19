class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();

        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[n][m] = true;

        for (int i = n; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                char pChr = p.charAt(j);

                boolean isMatch = i < n && (s.charAt(i) == pChr || pChr == '.');

                if (j + 1 < m && p.charAt(j + 1) == '*') {
                    dp[i][j] = isMatch && dp[i + 1][j] || dp[i][j + 2] /* match zero*/;
                } else {
                    dp[i][j] = isMatch && dp[i + 1][j + 1];
                }
            }
        }

        return dp[0][0];
    }
}
