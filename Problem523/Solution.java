import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Set<Integer> sumByIdx  = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum % k == 0) {

                if (sum == 0 && i > 1) {
                    return true;
                }

                return false;
            }

            if (!sumByIdx.add(sum % k)) {
                return true;
            }
        }


        return false;
    }
}