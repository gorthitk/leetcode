class Solution {
    public int longestValidParentheses(String s) {
        int max = 0, n = s.length();
        int[] dp = new int[n];

        for (int i = 1; i < n; i++) {
            char ch = s.charAt(i);
            if (ch != ')') {
                continue;
            }

            if (s.charAt(i-1) == '(') {
                dp[i] = (i > 1 ? dp[i-2] : 0) + 2;
            } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }
}