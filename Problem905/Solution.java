class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            while (i < nums.length - 1 && nums[i] % 2 == 0) {
                i++;
            }

            while (j >= 0 && nums[j] % 2 != 0) {
                j++;
            }

            if (i >= j) {
                break;
            }

            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;

            i++;
            j--;
        }

        return nums;
    }
}