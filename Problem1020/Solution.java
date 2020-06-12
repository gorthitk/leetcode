/**
 * @author tgorthi
 * @since Jun 2020
 */
class Solution
{
    public int numEnclaves(int[][] A)
    {
        int count = 0;
        int n = A.length; // number of rows        int m = A[0].length; // number of columns        for (int i = 0; i
        // < m; i++)        {            if (A[0][i] == 1)            {                _reachBoundary(0, i, n, m, A);
        // }            if (A[n - 1][i] == 1)            {                _reachBoundary(n - 1, i, n, m, A);
        // }        }        for (int i = 0; i < n; i++)        {            if (A[i][0] == 1)            {
        // _reachBoundary(i, 0, n, m, A);            }            if (A[i][m - 1] == 1)            {
        // _reachBoundary(i, m - 1, n, m, A);            }        }        for (int i = 0; i < n; i++)        {
        // for (int j = 0; j < m; j++)            {                if (A[i][j] == 1)                {
        // count++;                }            }        }        return count;    }    private void _reachBoundary
        // (int i, int j, int n, int m, int[][] A)    {        if (i < 0 || i >= n || j < 0 || j >= m)        {
        // return;        }        if (A[i][j] == 0 || A[i][j] == -1)        {            return;        }
        // A[i][j] = -1;        _reachBoundary(i + 1, j, n, m, A);        _reachBoundary(i - 1, j, n, m, A);
        // _reachBoundary(i, j + 1, n, m, A);        _reachBoundary(i, j - 1, n, m, A);    }}