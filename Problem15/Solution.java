class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    int b = nums[j], c = nums[k];
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    while(j < n && nums[j] == b) {
                        j++;
                    }
                    while(k >= 0 && nums[k] == c) {
                        k--;
                    }
                }
            }
        }

        return result;
    }
}