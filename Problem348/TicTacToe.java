class TicTacToe {
    private final int[][] grid;
    private int winner;

    public TicTacToe(int n) {
        this.grid = new int[n][n];
        this.winner = 0;
    }

    public int move(int row, int col, int player) {
        if (winner != 0) {
            return winner;
        }

        grid[row][col] = player;

        if (checkRow(row, player) || checkColumn(col, player) || checkDiagonal(player) || checkAntiDiagonal(player)) {
            winner = player;
        }

        return winner;
    }

    private boolean checkRow(int row, int player) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            if (grid[row][i] != player) {
                return false;
            }
        }

        return true;
    }

    private boolean checkColumn(int col, int player) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            if (grid[i][col] != player) {
                return false;
            }
        }

        return true;
    }


    private boolean checkDiagonal(int player) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            if (grid[i][i] != player) {
                return false;
            }
        }

        return true;
    }


    private boolean checkAntiDiagonal(int player) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            if (grid[i][n - i - 1] != player) {
                return false;
            }
        }

        return true;
    }
}