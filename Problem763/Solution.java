import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] index = new int[26];
        int n = s.length();
        for (int i  = 0; i < n; i++) {
            index[s.charAt(i) - 'a'] = i;
        }


        List<Integer> result = new ArrayList<>();
        int start = 0, currentEnd = 0;
        for (int i  = 0; i < n; i++) {
            char ch = s.charAt(i);

            currentEnd = Math.max(currentEnd, index[ch - 'a']);

            if (currentEnd == i) {
                result.add(currentEnd - start + 1);
                start = i + 1;
            }
        }


        return result;
    }
}