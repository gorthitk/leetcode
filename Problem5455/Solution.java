

class Solution
{
    public int minDays(int[] bloomDay, int m, int k)
    {
        if (m * k > bloomDay.length)
        {
            return -1;
        }


        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int day : bloomDay)
        {
            min = Math.min(min, day);
            max = Math.max(max, day);
        }

        int l = min, r = max;

        while (l < r)
        {
            int mid = (l + r) / 2;

            int numberOfBoqu = _calculate(bloomDay, k, mid);

            if (numberOfBoqu >= m)
            {
                r = mid;
            }
            else
            {
                l = mid + 1;
            }
        }

        return r;
    }


    private int _calculate(int[] bloomDay, int k, int mid)
    {
        int n = bloomDay.length;
        boolean[] canBeTaken = new boolean[n];

        for (int i = 0; i < n; i++)
        {
            if (bloomDay[i] <= mid)
            {
                canBeTaken[i] = true;
            }
        }


        int count = 0;

        int i = 0;
        while (i < n)
        {
            if (!canBeTaken[i])
            {
                i++;
                continue;
            }

            int numberOfFlowers = 0;
            while (numberOfFlowers < k && i < n && canBeTaken[i])
            {
                i++;
                numberOfFlowers++;
            }

            if (numberOfFlowers == k)
            {
                count++;
            }
        }

        return count;
    }
}