import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> rows = new HashMap<>();
        Map<Integer, Set<Integer>> cols = new HashMap<>();
        Map<Integer, Set<Integer>> sqrs = new HashMap<>();


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                int d = board[i][j] - '0';
                int idx = (i / 3) * 3 + (j / 3);

                boolean isValid = rows.computeIfAbsent(i, key -> new HashSet<>()).add(d)
                        && cols.computeIfAbsent(j, key -> new HashSet<>()).add(d)
                        && sqrs.computeIfAbsent(idx, key -> new HashSet<>()).add(d);

                if (!isValid) {
                    return false;
                }
            }
        }

        return true;
    }
}