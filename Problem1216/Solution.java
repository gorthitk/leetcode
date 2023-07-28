class Solution {
    public boolean isValidPalindrome(String s, int k) {
        int n = s.length();
        Integer[][] memo = new Integer[n][n];
        backtrack(s.toCharArray(), 0, n - 1, memo);

        return memo[0][n-1] <= k;
    }

    private int backtrack(char[] arr, int i, int j, Integer[][] memo) {
        if (i > j) {
            return 0;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        if (arr[i] == arr[j]) {
            memo[i][j] =  backtrack(arr, i + 1, j - 1, memo);
            return memo[i][j];
        }


        memo[i][j] = 1 + Math.min(
                backtrack(arr, i, j - 1, memo),
                backtrack(arr, i + 1, j, memo)
        );

        return memo[i][j];
    }
}