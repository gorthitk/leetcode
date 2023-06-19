import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

class Solution {

    private Map<Integer, List<Integer>> indicies;
    public Solution(int[] nums) {
        this.indicies = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            indicies.computeIfAbsent(nums[i], k -> new ArrayList<>())
                    .add(i);
        }
    }

    public int pick(int target) {
        int random = ThreadLocalRandom.current().nextInt(0, indicies.get(target).size());

        return indicies.get(target).get(random);
    }
}