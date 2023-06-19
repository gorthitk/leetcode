import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> indexByNum = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (indexByNum.containsKey(target - num)) {
                result[0] = indexByNum.get(target - num);
                result[1] = i;
                break;
            } else {
                indexByNum.put(num, i);
            }
        }

        return result;
    }
}