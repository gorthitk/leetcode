import java.util.Arrays;

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        int[] lens = new int[n];
        int[] counts = new int[n];

        Arrays.fill(counts, 1);
        Arrays.fill(lens, 1);

        int max = 1;
        int ans = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] <= nums[j]) {
                    continue;
                }

                if (lens[j] + 1 > lens[i]) {
                    lens[i] = lens[j] + 1;
                    counts[i] = counts[j];
                } else if (lens[j] + 1 == lens[i]) {
                    counts[i]+= counts[j];
                }
            }

            if (max > lens[i]) {
                max = lens[i];
                ans = counts[i];
            } else if (max == lens[i]) {
                ans += counts[i];
            }
            max = Math.max(max, lens[i]);
        }


        int result = 0;
        for (int i = 0; i < n; i++) {
            if (lens[i] == max) {
                result += counts[i];
            }
        }
        return ans;
    }
}