class NumMatrix {
    int[][] prefixSum;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        this.prefixSum = new int[n][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= m; j++) {
                this.prefixSum[i][j] = this.prefixSum[i][j - 1] + matrix[i][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;

        for (int i = row1; i <= row2; i++) {
            sum += prefixSum[i][col2 + 1] - prefixSum[i][col1];
        }

        return sum;
    }
}