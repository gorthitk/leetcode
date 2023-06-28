class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums1) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        int idx = 0;
        for (int num : nums2) {
            int cnt = count.getOrDefault(num, 0);

            if (cnt > 0) {
                nums1[idx++] = num;
                count.put(num, cnt - 1);
            }
        }

        return Arrays.copyOfRange(nums1, 0, idx);
    }
}