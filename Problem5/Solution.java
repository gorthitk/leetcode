class Solution {
    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        boolean[][] dp = new boolean[n][n];

        int[] result = new int[]{0, 0};
        int max = 1;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = arr[i] == arr[j] && (i + 1 <= j - 1 ? dp[i + 1][j - 1] : true);
                if (dp[i][j] && max < j - i + 1) {
                    result = new int[]{i, j};
                    max = j - i + 1;
                }
            }
        }


        return s.substring(result[0], result[1] + 1);

    }
}