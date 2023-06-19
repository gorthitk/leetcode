
class Solution
{
    public int minEatingSpeed(int[] piles, int H)
    {
        int max = 0;
        for (int pile : piles)
        {
            max = Math.max(max, pile);
        }
        int l = 1, r = max;
        while (l < r)
        {
            int mid = (r + l) / 2;
            int numberOfHoursNeeded = _calculateHoursNeeded(piles, mid);
            if (numberOfHoursNeeded > H)
            {
                l = mid + 1;
            }
            else
            {
                r = mid;
            }
        }
        return r;
    }

    private int _calculateHoursNeeded(int[] piles, int mid)
    {
        int hoursNeeded = 0;
        for (int pile : piles)
        {
            hoursNeeded += pile / mid + (pile % mid != 0 ? 1 : 0);
        }
        return hoursNeeded;
    }
}