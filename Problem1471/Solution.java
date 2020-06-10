import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution
{
    public int[] getStrongest(int[] arr, int k)
    {
        Arrays.sort(arr);

        final int n = arr.length;
        final int m = (n - 1) / 2;
        final int median = arr[m];


        List<Integer> nums = new ArrayList<>();

        for (int num : arr)
        {
            nums.add(num);
        }

        int[] result = new int[k];

        var numsAsList = nums.stream()
                .sorted((a,b) -> {
                    if (!a.equals(b))
                    {
                        int diffA = Math.abs(a - median);
                        int diffB = Math.abs(b - median);

                        if (diffA != diffB)
                        {
                            return Integer.compare(diffB, diffA);
                        }
                        else
                        {
                            return Integer.compare(b, a);
                        }
                    }

                    return 0;
                })
                .limit(k)
                .collect(Collectors.toList());

        for (int i = 0; i < k; i++)
        {
            result[i] = numsAsList.get(i);
        }

        return result;
    }
}