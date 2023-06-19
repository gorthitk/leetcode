

import java.util.Random;

public class Solution
{
    int[] nums;

    public Solution(int[] nums)
    {
        this.nums = nums;
    }

    public int[] reset()
    {
        return nums;
    }

    public int[] shuffle()
    {
        int[] shuffle = nums.clone();
        Random rand = new Random();
        for (int i = 0; i < nums.length; i++)
        {
            int idx = rand.nextInt(i + 1);
            swap(i, idx, shuffle);
        }
        return shuffle;
    }

    private void swap(int i, int idx, int[] shuffle)
    {
        int tmp = shuffle[i];
        shuffle[i] = shuffle[idx];
        shuffle[idx] = tmp;
    }
}