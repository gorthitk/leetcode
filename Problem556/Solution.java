public class Solution
{
    private int min;

    public int nextGreaterElement(int num)
    {
        min = Integer.MAX_VALUE;
        int[] counts = new int[10];
        int len = 0;
        int trgt = num;
        while (num > 0)
        {
            int digit = num % 10;
            counts[digit]++;
            num /= 10;
            len++;
        }
        findMin(counts, len, 0, trgt, 0);
        if (min == Integer.MAX_VALUE)
            return -1;
        return min;
    }

    private void findMin(int[] counts, int len, int currLen, int num, int curr)
    {
        if (currLen == len)
        {
            if (curr > num)
            {
                min = Math.min(curr, min);
            }
            return;
        }
        for (int i = 0; i <= 9; i++)
        {
            if (counts[i] != 0)
            {
                int k = counts[i];
                while (k > 0)
                {
                    int[] arr = getArray(counts);
                    arr[i]--;
                    int tmp = curr * 10 + i;
                    findMin(arr, len, currLen + 1, num, tmp);
                    k--;
                }
            }
        }
    }

    private int[] getArray(int[] counts)
    {
        int[] ret = new int[10];
        for (int i = 0; i <= 9; i++)
        {
            ret[i] = counts[i];
        }
        return ret;
    }
}