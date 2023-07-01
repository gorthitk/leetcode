class Solution {
    public boolean isValidPalindrome(String s, int k) {
        int n = s.length();
        Integer[][] memo = new Integer[n][n];
        char[] arr = s.toCharArray();

        return isValidPalindrome(arr, 0, n - 1, memo) <= k;
    }

    private int isValidPalindrome(char[] arr, int i, int j, Integer[][] memo) {
        int n = arr.length;

        if (i == j) {
            return 0;
        }

        if (i == j - 1) {
            return arr[i] == arr[j] ? 0 : 1;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        if (arr[i] == arr[j]) {
            return isValidPalindrome(arr, i + 1, j - 1, memo);
        }

        memo[i][j] = 1 + Math.min(
                isValidPalindrome(arr, i + 1, j, memo),
                isValidPalindrome(arr, i, j - 1, memo)
        );;

        return memo[i][j];
    }
}