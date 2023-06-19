class Solution {

    public boolean validPalindrome(String s) {
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;

        while (i < j) {
            if (arr[i] != arr[j]) {
                return checkPalindrome(arr, i + 1, j) || checkPalindrome(arr, i, j - 1);
            }

            i++;
            j--;
        }

        return true;

    }

    private boolean checkPalindrome(char[] arr, int st, int end) {
        while (st < end) {
            if (arr[st++] != arr[end--]) {
                return false;
            }
        }

        return true;
    }
}