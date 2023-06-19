import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumCount = new HashMap<>();
        sumCount.put(0, 1);

        int sum = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result += sumCount.getOrDefault(sum - k, 0);
            sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}