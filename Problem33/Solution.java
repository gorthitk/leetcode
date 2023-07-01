class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int pivot = findPivot(nums);

        if (pivot == -1) {
            return -1;
        }

        if (pivot == 0) {
            return search(nums, 0, n - 1, target);
        }

        if (target > nums[n - 1]) {
            return search(nums, 0, pivot - 1, target);
        }

        return search(nums, pivot, n - 1, target);
    }

    private int search(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = (r + l) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }


    private int findPivot(int[] nums) {
        if (nums[0] < nums[nums.length - 1]) {
            return 0;
        }

        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (j + i) / 2;

            if (nums[mid] > nums[mid + 1]) {
                return mid + 1;
            }

            if (nums[mid] < nums[mid - 1]) {
                return mid;
            }

            if (nums[mid] > nums[0]) {
                i = mid + 1;
            } else {
                j = mid -1;
            }
        }


        return -1;
    }
}