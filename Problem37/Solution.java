import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    private static final int N = 9;

    private Map<Integer, Set<Integer>> rows;
    private Map<Integer, Set<Integer>> cols;
    private Map<Integer, Set<Integer>> sqrs;

    private char[][] board;
    private boolean isSolved = false;

    public void solveSudoku(char[][] board) {
        this.board = board;
        rows = new HashMap<>();
        cols = new HashMap<>();
        sqrs = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            rows.put(i, new HashSet<>());
            cols.put(i, new HashSet<>());
            sqrs.put(i, new HashSet<>());
        }

        // Update current state.
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    setNum(i, j, board[i][j] - '0');
                }
            }
        }


        backtrack(0, 0);
    }

    private void setNum(int i, int j, int d) {
        board[i][j] = (char) (d + '0');
        int k = (i / 3) * 3 + (j / 3);
        rows.get(i).add(d);
        cols.get(j).add(d);
        sqrs.get(k).add(d);

    }


    private void removeNum(int i, int j, int d) {
        board[i][j] = '.';
        int k = (i / 3) * 3 + (j / 3);
        rows.get(i).remove(d);
        cols.get(j).remove(d);
        sqrs.get(k).remove(d);
    }

    private void placeNext(int i, int j) {
        if (i == N - 1 && j == N - 1) {
            isSolved = true;
            return;
        }

        if (j == N - 1) {
            backtrack(i + 1, 0);
        } else {
            backtrack(i, j + 1);
        }

    }

    private void backtrack(int i, int j) {
        if (board[i][j] == '.') {
            for (int k = 1; k < 10; k++) {
                if (isValid(i, j, k)) {
                    setNum(i, j, k);
                    placeNext(i, j);
                    if (!isSolved) {
                        removeNum(i, j, k);
                    }
                }
            }
        } else {
            placeNext(i, j);
        }
    }

    private boolean isValid(int i, int j, int num) {
        int idx = (i / 3) * 3 + (j / 3);

        return !rows.get(i).contains(num) && !cols.get(j).contains(num) && !sqrs.get(idx).contains(num);
    }

}