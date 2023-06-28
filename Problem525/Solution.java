class Solution {
    public int findMaxLength(int[] nums) {
        int max = 0;
        int n = nums.length;


        Map<Integer, Integer> sumByIdx = new HashMap<>();
        sumByIdx.put(0, -1);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (nums[i] == 1 ? 1 : -1);

            if (sumByIdx.containsKey(sum)) {
                max = Math.max(max, i - sumByIdx.get(sum));
            } else {
                sumByIdx.put(sum, i);
            }
        }


        return max;
    }
}