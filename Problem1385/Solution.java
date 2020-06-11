class Solution
{
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d)
    {
        int distance = arr1.length;
        for (int num : arr1)
        {
            for (int a : arr2)
            {
                if (Math.abs(num - a) <= d)
                {
                    distance--;
                    break;
                }
            }
        }

        return distance;
    }
}