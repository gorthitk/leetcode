class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;


        int[] count = new int[256];
        int distinctCount = 0;
        int start = 0, result = 0;

        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
            if (count[arr[i]] == 1) {
                distinctCount++;
            }


            while (distinctCount > k) {
                count[arr[start]]--;
                if (count[arr[start]] == 0) {
                    distinctCount--;
                }

                start++;
            }


            result = Math.max(result, i - start + 1);
        }


        return result;
    }
}
