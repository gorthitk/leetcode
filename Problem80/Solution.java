class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        int count = 1;
        int prev = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (prev == nums[i]) {
                count++;
                if (count <= 2) {
                    nums[k++] = nums[i];
                }
            } else {
                nums[k++] = nums[i];
                prev = nums[i];
                count = 1;
            }
        }

        return k;
    }
}