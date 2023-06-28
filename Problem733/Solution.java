class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length, m = image[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];
            if (visited[x][y]) {
                continue;
            }

            if (x > 0 && image[x - 1][y] == image[x][y]) {
                queue.add(new int[]{x-1, y});
            }

            if (y > 0 && image[x][y-1] == image[x][y]) {
                queue.add(new int[]{x, y-1});
            }

            if (x < n - 1 && image[x + 1][y] == image[x][y]) {
                queue.add(new int[]{x+1, y});
            }

            if (y < m - 1 && image[x][y+1] == image[x][y]) {
                queue.add(new int[]{x, y+1});
            }

            image[x][y] = color;
            visited[x][y] = true;
        }

        return image;
    }
}