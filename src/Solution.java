import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        map.put(0, -1);
        int sum = 0;
        int len = 0;


        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map.putIfAbsent(sum, i);

            int diff = sum - k;
            if (map.containsKey(diff)) {
                len = Math.max(len, i - map.get(diff));
            }

        }


        return len;
    }
}