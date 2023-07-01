class Solution {
    public String tictactoe(int[][] moves) {
        int[][] grid = new int[3][3];
        int player = 1;
        for (int[] move : moves) {
            int i = move[0], j = move[1];
            grid[i][j] = player;
            if (check(grid, player, i, j)) {
                return player == 1 ? "A" : "B";
            }

            player = player == 1 ? 2 : 1;
        }

        int zeros = 9 - moves.length;
        return zeros == 0 ? "Draw" : "Pending";
    }

    private boolean check(int[][] moves, int p, int r, int c) {
        return checkRow(moves, r, p) || checkCol(moves, c, p) || checkDiagonal(moves, p) || checkAntiDiagonal(moves, p);
    }
    private boolean checkRow(int[][] moves, int row, int player) {
        for (int i = 0; i < 3; i++) {
            if (moves[row][i] != player) {
                return false;
            }
        }

        return true;
    }

    private boolean checkCol(int[][] moves, int col, int player) {
        for (int i = 0; i < 3; i++) {
            if (moves[i][col] != player) {
                return false;
            }
        }

        return true;
    }

    private boolean checkDiagonal(int[][] moves, int player) {
        int col = 0;
        for (int i = 0; i < 3; i++) {
            if (moves[i][col] != player) {
                return false;
            }
            col++;
        }

        return true;
    }

    private boolean checkAntiDiagonal(int[][] moves, int player) {
        for (int i = 0; i < 3; i++) {
            if (moves[i][2 - i] != player) {
                return false;
            }
        }

        return true;
    }
}