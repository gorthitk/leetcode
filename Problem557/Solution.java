class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int curr = 0;
        int n = s.length();
        for (int i = 0; i <= n; i++) {
            if (i == n || arr[i] == ' ') {
                swap(arr, curr, i - 1);
                curr = i + 1;
            }
        }

        return new String(arr);
    }

    private static void swap(char[] arr, int i, int j) {
        while(i < j) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }
}