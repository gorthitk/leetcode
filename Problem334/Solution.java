class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }

        return false;
    }
}