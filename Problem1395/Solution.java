/**
 * @author tgorthi
 * @since Jun 2020
 */
class Solution
{
    public int numTeams(int[] rating)
    {
        final int n = rating.length;
        int teams = 0;
        final int[] increasing = new int[n];
        final int[] decreasing = new int[n];
        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                if (rating[i] < rating[j])
                {
                    decreasing[i]++;
                }
                if (rating[i] > rating[j])
                {
                    increasing[i]++;
                }
            }
        }
        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                if (rating[i] < rating[j] && decreasing[j] > 0)
                {
                    teams += decreasing[j];
                }
                if (rating[i] > rating[j] && increasing[j] > 0)
                {
                    teams += increasing[j];
                }
            }
        }
        return teams;
    }
}