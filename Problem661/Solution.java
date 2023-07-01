class Solution {
    private static final int[][] DIRECTIONS = new int[][] {
            {-1, 0},
            {1,0},
            {0, 1},
            {0, -1},
            {-1, -1},
            {1, -1},
            {1, 1},
            {-1, 1}
    };

    public int[][] imageSmoother(int[][] img) {
        int n = img.length, m = img[0].length;
        int[][] result = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = getAvg(i,j, img);
            }
        }

        return result;
    }

    private int getAvg(int i, int j, int[][] img) {
        int sum = img[i][j];
        int count = 1;
        for (int[] dir : DIRECTIONS) {
            int a = dir[0] + i, b = dir[1] + j;
            if (isValid(a, b, img.length, img[0].length)) {
                sum += img[a][b];
                count++;
            }
        }

        return sum / count;
    }
    private boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }
}