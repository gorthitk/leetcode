
public class Solution
{
    public int findPoisonedDuration(int[] timeSeries, int duration)
    {
        if (timeSeries == null || timeSeries.length == 0)
        {
            return 0;
        }
        int time = 0;
        int poisonedTimeStart = timeSeries[0];
        int poisonedTimeEnd = timeSeries[0] + duration;
        for (int i = 1; i < timeSeries.length; i++)
        {
            if (timeSeries[i] > poisonedTimeEnd)
            {
                time += (poisonedTimeEnd - poisonedTimeStart);
                poisonedTimeStart = timeSeries[i];
            }
            poisonedTimeEnd = timeSeries[i] + duration;
        }
        return time + (poisonedTimeEnd - poisonedTimeStart);
    }
}