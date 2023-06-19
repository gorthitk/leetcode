import java.util.HashMap;
import java.util.Map;

class SparseVector {
    Map<Integer, Integer> nonZeros;
    SparseVector(int[] nums) {
        nonZeros = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nonZeros.put(i, nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int result = 0;
        for (int key : nonZeros.keySet()) {
            if (vec.nonZeros.containsKey(key)) {
                result += nonZeros.get(key) * vec.nonZeros.get(key);
            }
        }


        return result;
    }
}