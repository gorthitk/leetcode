class Solution {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) {
            return "";
        }

        int n = palindrome.length();
        char[] arr = palindrome.toCharArray();

        for (int i = 0; i < n / 2; i++) {
            if (arr[i] != 'a') {
                arr[i] = 'a';
                return new String(arr);
            }
        }

        // all characters are a.
        arr[n - 1] = 'b';

        return new String(arr);
    }
}