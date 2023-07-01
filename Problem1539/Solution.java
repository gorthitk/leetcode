class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;

        if (n == 0) {
            return k;
        }

        if (arr[0] != 1) {
            if (arr[0] - 1 >= k) {
                return k;
            }
            k = k - (arr[0] - 1);
        }

        for (int i  = 1; i < n; i++) {
            int d = arr[i] - arr[i - 1];
            if (d != 1) {
                if (d >= k) {
                    return arr[i - 1] + k;
                } else {
                    k = k - d + 1;
                }
            }
        }

        return arr[n - 1] + k;
    }
}