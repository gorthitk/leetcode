import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] count = new int[2001];

        for (int num : arr) {
            count[num + 1000]++;
        }

        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < 2001; i++) {
            if (count[i] == 0) {
                continue;
            }


            if (!seen.add(count[i])) {
                return false;
            }
        }

        return true;
    }
}