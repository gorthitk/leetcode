import java.util.*;

class Solution {
    public List<Integer> findClosestElements(int[] nums, int k, int pivot) {

        List<Integer> result = new ArrayList<>();

        List<Integer> numList = new ArrayList<>();
        for (int n : nums) {
            numList.add(n);
        }

        numList.sort(
                (a,b) -> {
                    int x = Math.abs(a - pivot);
                    int y = Math.abs(b - pivot);

                    return x != y ? x - y : a - b;
                }
        );


        for (int i = 0; i < Math.min(k, nums.length); i++) {
            result.add(numList.get(i));
        }

        Collections.sort(result);

        return result;
    }
}