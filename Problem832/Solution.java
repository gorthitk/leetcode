class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length, m = image[0].length;

        for (int i = 0; i < n; i++) {
            int j = 0, k = m - 1;

            while (j <= k) {
                int tmp = image[i][j];
                image[i][j] = image[i][k] == 1 ? 0 : 1;
                if (j != k) {
                    image[i][k] = tmp == 1 ? 0 : 1;
                }
                j++;
                k--;
            }


        }

        return image;
    }
}