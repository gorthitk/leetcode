class Solution {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;

        int[] count = new int[32];
        for (int i = 0; i < n; i++) {
            int c = nums[i];
            int idx = 31;

            while (c != 0) {
                if ((c & 1) == 1) {
                    count[idx]++;
                }
                c = c >> 1;
                idx--;
            }
        }


        int ans = 0;
        for (int c : count) {
            ans += c * (n - c);
        }

        return ans;
    }

}
