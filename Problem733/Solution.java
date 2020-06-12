/**
 * @author tgorthi
 * @since Jun 2020
 */
class Solution
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        int l = image.length, b = image[0].length;
        boolean[][] visited = new boolean[l][b];
        fill(visited, image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    private void fill(boolean[][] visited, int[][] image, int x, int y, int newColor, int oldColor)
    {
        if (x < 0 || y < 0 || x >= visited.length || y >= visited[0].length || visited[x][y] || image[x][y] != oldColor)
        {
            return;
        }
        visited[x][y] = true;
        image[x][y] = newColor;
        fill(visited, image, x - 1, y, newColor, oldColor);
        fill(visited, image, x + 1, y, newColor, oldColor);
        fill(visited, image, x, y + 1, newColor, oldColor);
        fill(visited, image, x, y - 1, newColor, oldColor);
    }
}