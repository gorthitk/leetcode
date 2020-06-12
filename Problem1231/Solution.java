class Solution
{
    public int maximizeSweetness(int[] sweetness, int K)
    {
        int total = 0;
        int min = Integer.MAX_VALUE;
        for (int sweet : sweetness)
        {
            total += sweet;
            min = Math.min(min, sweet);
        }

        int l = min, r = total;

        while (l < r)
        {
            int mid = l + (r - l) / 2;
            int groups = 0;
            int current = 0;

            for (int sweet : sweetness)
            {
                current += sweet;

                if (current > mid)
                {
                    current = 0;
                    groups++;
                }
            }

            if (groups > K)
            {
                l = mid + 1;
            }
            else
            {
                r = mid;
            }
        }

        return l;
    }
}