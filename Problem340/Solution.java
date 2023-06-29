class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        char[] arr = s.toCharArray();
        int start = 0, max = 0;
        int[] count = new int[128];
        int seen = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = arr[i];
            count[ch]++;

            if (count[ch] == 1) {
                seen++;
            }

            if (seen <= k) {
                max = Math.max(max, i - start + 1);
            } else {
                start = remove(start, i, arr, count, k);
                seen--;
            }
        }

        return max;
    }

    private int remove(int start, int end, char[] arr, int[] count, int k) {
        int j = start;
        for (; j <= end; j++) {
            char chr = arr[j];
            count[chr]--;

            if (count[chr] == 0) {
                break;
            }
        }

        return j + 1;
    }
}