class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];

        int[] nums = Arrays.copyOf(arr, n);
        Arrays.sort(nums);



        Map<Integer, Integer> rank = new HashMap<>();
        int curr = 1;
        for (int i = 0; i < n; i++) {
            if (!rank.containsKey(nums[i])) {
                rank.put(nums[i], curr);
                curr++;
            }
        }

        for (int i = 0; i < n; i++) {
            result[i] = rank.get(arr[i]);
        }

        return result;
    }
}