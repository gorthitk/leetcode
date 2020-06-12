class Solution
{
    public int findJudge(int N, int[][] trust)
    {
        final int[] count = new int[N + 1];

        for (int[] tr : trust)
        {
            count[tr[1]]++;
            count[tr[0]]--;
        }

        for (int i = 1; i <= N; i++)
        {
            if (count[i] == N - 1)
            {
                return i;
            }
        }
        return -1;
    }
}