import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(0, 1);
        int sum = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int q = (sum % k + k) % k;

            if (counts.containsKey(q)) {
                result += counts.get(q);
            }

            counts.put(q, counts.getOrDefault(q, 0) + 1);
        }

        return result;
    }
}
