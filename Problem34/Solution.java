class Solution {
    public int[] searchRange(int[] nums, int target) {
        // O(logn)
        return search(nums, target, 0, nums.length - 1);
    }


    private int[] search(int[] nums, int target, int start, int end) {
        if (start > end) {
            return new int[] {-1, -1};
        }
        int mid = (end + start) / 2;
        if (nums[mid] > target) {
            return search(nums, target, start, mid - 1);
        }

        if (nums[mid] < target) {
            return search(nums, target, mid + 1, end);
        }

        int[] left = search(nums, target, start, mid - 1);
        int[] right = search(nums, target, mid + 1, end);

        int[] result = new int[] {mid, mid};
        if (left[0] != -1) {
            result[0] = left[0];
        }

        if (right[1] != -1) {
            result[1] = right[1];
        }

        return result;
    }
}