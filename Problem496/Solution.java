import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> index = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            index.put(nums2[i], i);
        }

        int n = nums1.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int num = nums1[i];
            int max = -1;

            for (int j = index.get(num) + 1; j < nums2.length; j++) {
                if (nums2[j] > num) {
                    max = nums2[j];
                    break;
                }
            }

            result[i] = max;
        }

        return result;
    }
}