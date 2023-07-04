import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= Math.min(9, n); ++i) {
            backtrack(i, result, n);
        }

        return result;
    }

    private void backtrack(int curr, List<Integer> result, int n) {
        result.add(curr);
        for (int i = 0; i < 10; i++) {
            if (curr * 10 + i > n) {
                break;
            }
            backtrack(curr * 10 + i, result, n);
        }
    }
}