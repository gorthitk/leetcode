class Solution {
    public int numDecodings(String s) {
        char[] arr = s.toCharArray();
        if (arr[0] == '0') {
            return 0;
        }

        int n = arr.length;

        int[] counts = new int[n];
        counts[0] = 1;
        for (int i = 1; i < n; i++) {
            char ch = arr[i];
            if (ch >= '1' && ch <= '9') {
                counts[i] += counts[i-1];
            }

            if (arr[i - 1] == '1' || (arr[i - 1] == '2' && ch <= '6')) {
                counts[i] += i - 2 < 0 ? 1 : counts[i - 2];
            }
        }



        return counts[n - 1];
    }
}